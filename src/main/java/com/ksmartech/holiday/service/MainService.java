package com.ksmartech.holiday.service;


import com.ksmartech.holiday.mapper.MainMapper;
import com.ksmartech.holiday.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    MainMapper mainMapper;

    public List<DetailHolidayDto> empInfo(String empNo){
        List<DetailHolidayDto> result = (List<DetailHolidayDto>) mainMapper.getInfo(empNo);
        return result;
    }

    public HolidayDto getEmpInfo(String empNo){
        HolidayDto result2 = mainMapper.getEmpInfo(empNo);
        return result2;
    }

    public EmpDto showEmpInfo(String empNo){
        EmpDto result = mainMapper.showEmpInfo(empNo);
        return result;
    }



    public ResponseModel resignEmp (String empNo){

        int result = mainMapper.resignEmp(empNo);

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





