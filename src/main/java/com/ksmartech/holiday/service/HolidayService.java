package com.ksmartech.holiday.service;

import com.ksmartech.holiday.mapper.EmployeeMapper;
import com.ksmartech.holiday.mapper.HolidayMapper;
import com.ksmartech.holiday.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public List<DetailHolidayDto> empInfo(String empNo) {
        List<DetailHolidayDto> result = holidayMapper.getInfo(empNo);
        return result;
    }

    // 잔여일 조회
    public HolidayDto getEmpInfo(String empNo) {
        HolidayDto result = holidayMapper.getEmpInfo(empNo);
        return result;
    }

    // 신청
    public ResponseModel applyHoli(ApplyHoliDto applyHoliDto) {

        int result = holidayMapper.applyEmp(applyHoliDto);

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

        List<DetailHolidayDto> result = holidayMapper.checkApproval(team, empNo);
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

    // 오늘 날짜에 해당하는 승인 휴가 조회
    public void findApprovalHoli() {

        GregorianCalendar cal = new GregorianCalendar();

        Date dt = cal.getTime();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = dateFormat.format(dt);
        logger.debug(strDate);

        int a = holidayMapper.findApprovalHoli(strDate); //승인상태db 가져오삼

        logger.debug(a+"");

    }


    // @Scheduled(cron="0 0 02 * * ?") 매일 새벽2시 실행
    @Scheduled(fixedDelay = 2000, initialDelay = 3000)
    @Transactional
    public void scheduleTest() {
        logger.debug("HolidayService 내부");

        findApprovalHoli();

    }
}
