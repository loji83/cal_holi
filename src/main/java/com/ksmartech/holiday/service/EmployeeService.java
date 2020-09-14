package com.ksmartech.holiday.service;


import com.ksmartech.holiday.mapper.EmployeeMapper;
import com.ksmartech.holiday.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EmployeeMapper employeeMapper;


    // 사원 정보 조회
    public EmpDto showEmpInfo(String empNo){
        EmpDto result = employeeMapper.showEmpInfo(empNo);
        return result;
    }

    // 신규사원 입사
    public ResponseModel newEmp(EmpDto empDto){
        int result = employeeMapper.newEmp(empDto);

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

    // 퇴사
    public ResponseModel resignEmp (String empNo){

        int result = employeeMapper.resignEmp(empNo);

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





