package com.ksmartech.holiday.service;

import com.ksmartech.holiday.mapper.EmployeeMapper;
import com.ksmartech.holiday.mapper.HolidayMapper;
import com.ksmartech.holiday.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Console;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class HolidayService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    HolidayMapper holidayMapper;

    @Autowired
    EmployeeMapper employeeMapper;

    // 휴가 내역조회
    public List<DetailHolidayDto> holiList(String empNo) {
        List<DetailHolidayDto> result = holidayMapper.getHoliList(empNo);
        return result;
    }

    // 잔여일 조회
    public HolidayDto cntUsedHoli(String empNo) {

        //logger.debug("empNo: " + empNo);
        HolidayDto result = holidayMapper.cntUsedHoli(empNo);

       //logger.debug(result.toString());
        return result;
    }

    // 신청
    public ResponseModel applyHoli(ApplyHoliDto applyHoliDto) {

        if (applyHoliDto.getHoliType().equals("반차")) {
            applyHoliDto.setDuration(0.5);
            applyHoliDto.setEndDate(applyHoliDto.getStartDate());

        } else {
            //
            Date start = applyHoliDto.getStartDate();
            Date end = applyHoliDto.getEndDate();

            Calendar cal1 = Calendar.getInstance();
            Calendar cal2 = Calendar.getInstance();
            cal1.setTime(start);
            cal2.setTime(end);

            logger.debug(cal1 + " / " + cal2);

            double numberOfDays = 1;
            while (cal1.before(cal2)) {
                logger.debug(cal1.before(cal2) + "");
                if ((Calendar.SATURDAY != cal1.get(Calendar.DAY_OF_WEEK))
                        && (Calendar.SUNDAY != cal1.get(Calendar.DAY_OF_WEEK))) {
                    numberOfDays++;
                }
                cal1.add(Calendar.DATE, 1);

            }

            logger.debug(String.valueOf(numberOfDays));
            applyHoliDto.setDuration(numberOfDays);
        }

        logger.debug(applyHoliDto.toString());
        int result = holidayMapper.applyHoli(applyHoliDto);

        //
        ResponseModel responseModel = new ResponseModel();

        if (result == 1) {
            responseModel.setCode("0000");
            responseModel.setMessage("Success");
        } else {
            responseModel.setCode("0001");
            responseModel.setMessage("No emp");
        }

        logger.debug(responseModel.toString());

        return responseModel;
    }

    // 결재 조회
    public ResponseModel checkApproval(String team, String empNo) {
        ResponseModel responseModel = new ResponseModel();
        if (!isTeamLeader(empNo)) {
            responseModel.setCode("0100");
            responseModel.setMessage("You're not leader.");

            return responseModel;
        }

        ArrayList<DetailHolidayDto> result = holidayMapper.checkApproval(team, empNo);
        responseModel.setCode("0000");
        responseModel.setMessage("Success");
        responseModel.setData(result);
        return responseModel;
    }


    // 승인 기능
    public ResponseModel approvalHoli(HoliParamDto holiParamDto) {

        ResponseModel responseModel = new ResponseModel();

        if (!isTeamLeader(holiParamDto.getEmpNo())) {
            responseModel.setCode("0100");
            responseModel.setMessage("You're not leader.");

            return responseModel;
        }

        int result = holidayMapper.approvalHoli(holiParamDto);

        if (result == 1) {
            responseModel.setCode("0000");
            responseModel.setMessage("Success");
        } else {
            responseModel.setCode("0001");
            responseModel.setMessage("No emp");
        }

        logger.debug(responseModel.toString());

        return responseModel;
    }

    //취소 기능
    public ResponseModel cancelHoli(HoliParamDto holiParamDto) {
        int result = holidayMapper.cancelHoli(holiParamDto);

        ResponseModel responseModel = new ResponseModel();

        if (result == 1) {
            responseModel.setCode("0000");
            responseModel.setMessage("Success");
        } else {
            responseModel.setCode("0001");
            responseModel.setMessage("No emp");
        }

        logger.debug(responseModel.toString());

        return responseModel;
    }

    private boolean isTeamLeader(String empNo) {

        String rank = employeeMapper.isLeader(empNo);
        if (rank.equals("팀장")) {
            return true;
        }
        return false;
    }


    @Transactional(rollbackFor = Exception.class)
    public void todayUpdate() {

        // 오늘 날짜 확인
        GregorianCalendar cal = new GregorianCalendar();

        Date dt = cal.getTime();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        String strDate = dateFormat.format(dt);
        logger.debug(strDate);

        // 오늘 날짜에 해당하는 승인 휴가 state = '사용' 변경
        int cnt = holidayMapper.changeApprovalHoli(strDate); //승인 상태 db 가져오삼
        logger.debug(cnt + "");

        // 오늘 날짜에 사용되는 휴가 list
        ArrayList<DetailHolidayDto> result = holidayMapper.getUpdatedHoli(strDate);
        logger.debug(result.toString());

        //잔여일, 사용날짜 계산
        for (int i = 0; i < result.size(); i++) {
            DetailHolidayDto detailHolidayDto = result.get(i);
            logger.debug(detailHolidayDto.toString());
            holidayMapper.calTotalHoliInfo(detailHolidayDto);
        }
    }

    // @Scheduled(cron="0 0 02 * * ?") 매일 새벽2시 실행
    //@Scheduled(fixedDelay = 10000, initialDelay = 3000)
    @Transactional(rollbackFor = Exception.class)
    public void scheduleTest() {

        todayUpdate();
    }
}
