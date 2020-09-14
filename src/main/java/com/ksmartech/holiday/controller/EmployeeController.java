package com.ksmartech.holiday.controller;

import com.ksmartech.holiday.model.*;
import com.ksmartech.holiday.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class EmployeeController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EmployeeService employeeService;


    //사원 정보 조회 기능
    @GetMapping(value = "/employee/{empNo}")
    @ResponseBody
    public EmpDto EmpInfo(@PathVariable String empNo){
        logger.debug(empNo);

        EmpDto result = employeeService.showEmpInfo(empNo);

        return result;
    }


    //퇴사 기능
    @PutMapping(value = "/employee/{empNo}")
    @ResponseBody
    public ResponseModel ResignEmp(@PathVariable String empNo){
        logger.debug(empNo);

        ResponseModel result = employeeService.resignEmp(empNo);

        return result;
    }


    //신규 사원 입사
    @PostMapping(value = "/employee")
    @ResponseBody
    public ResponseModel NewEmp(@RequestBody EmpDto empDto){

        ResponseModel result = employeeService.newEmp(empDto);

        return result;
    }
}