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

    /*
    @GetMapping(value = "/holiday/detail-info/{empNo}")
    @ResponseBody
    public List<DetailHolidayDto> detailHolidayInfo(@PathVariable String empNo){
        logger.debug(empNo);

        List<DetailHolidayDto> result = (List<DetailHolidayDto>) mainService.empInfo(empNo);

        return result;
    }


    @GetMapping(value = "/holiday/holi-info/{empNo}")
    @ResponseBody
    public HolidayDto HolidayInfo(@PathVariable String empNo) {
        logger.debug(empNo);

        HolidayDto result = mainService.getEmpInfo(empNo);

        return result;
    }


     */
    @GetMapping(value = "/employee/{empNo}")
    @ResponseBody
    public EmpDto EmpInfo(@PathVariable String empNo){
        logger.debug(empNo);

        EmpDto result = employeeService.showEmpInfo(empNo);

        return result;
    }

    @PutMapping(value = "/employee/{empNo}")
    @ResponseBody
    public ResponseModel ResignEmp(@PathVariable String empNo){
        logger.debug(empNo);

        ResponseModel result = employeeService.resignEmp(empNo);

        return result;
    }

    @PostMapping(value = "/employee")
    @ResponseBody
    public ResponseModel NewEmp(@RequestBody EmpDto empDto){

        ResponseModel result = employeeService.newEmp(empDto);

        return result;
    }
}