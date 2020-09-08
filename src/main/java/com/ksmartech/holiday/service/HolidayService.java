package com.ksmartech.holiday.service;

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


    public List<DetailHolidayDto> empInfo(String empNo){
        List<DetailHolidayDto> result = (List<DetailHolidayDto>) holidayMapper.getInfo(empNo);
        return result;
    }


    public HolidayDto getEmpInfo(String empNo){
        HolidayDto result = holidayMapper.getEmpInfo(empNo);
        return result;
    }


    public ResponseModel applyEmp(ApplyHoliDto applyHoliDto){

        int result = holidayMapper.applyEmp(applyHoliDto);

        ResponseModel responseModel = new ResponseModel();

        if(result == 1) {
            responseModel.setCode("0000");
            responseModel.setMessage("Success");
        } else {
            responseModel.setCode("0001");
            responseModel.setMessage("No emp");
        }

        logger.debug(responseModel.toString());

        return responseModel;
    }
}