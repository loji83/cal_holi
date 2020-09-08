package com.ksmartech.holiday.service;

import com.ksmartech.holiday.mapper.EmployeeMapper;
import com.ksmartech.holiday.mapper.HolidayMapper;
import com.ksmartech.holiday.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HolidayService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    HolidayMapper holidayMapper;

    @Autowired
    EmployeeMapper employeeMapper;


    public List<DetailHolidayDto> empInfo(String empNo) {
        List<DetailHolidayDto> result = (List<DetailHolidayDto>) holidayMapper.getInfo(empNo);
        return result;
    }


    public HolidayDto getEmpInfo(String empNo) {
        HolidayDto result = holidayMapper.getEmpInfo(empNo);
        return result;
    }


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
        if(!isTeamLeader(empNo)){
            responseModel.setCode("0100");
            responseModel.setMessage("You're not leader.");

            return responseModel;
        }

        List<DetailHolidayDto> result = (List<DetailHolidayDto>) holidayMapper.checkApproval(team, empNo);
        responseModel.setCode("0000");
        responseModel.setMessage("Success");
        responseModel.setData(result);
        return responseModel;
    }


    // 승인 기능
    public ResponseModel approvalHoli(HoliParamDto holiParamDto) {

        if(!isTeamLeader(holiParamDto.getEmpNo())){
            ResponseModel responseModel = new ResponseModel();
            responseModel.setCode("0100");
            responseModel.setMessage("You're not leader.");
            return responseModel;
        }

        int result = holidayMapper.approvalHoli(holiParamDto);

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
}
