package com.ksmartech.holiday.controller;

import com.ksmartech.holiday.model.*;
import com.ksmartech.holiday.service.HolidayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class HolidayController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    HolidayService holidayService;

    // 휴가 내역 조회 기능
    @GetMapping(value = "/holiday/detail/{empNo}")
    @ResponseBody
    public List<DetailHolidayDto> detailHolidayInfo(@PathVariable String empNo){
        logger.debug(empNo);

        List<DetailHolidayDto> result = (List<DetailHolidayDto>) holidayService.empInfo(empNo);

        return result;
    }

    // 잔여일 조회 기능
    @GetMapping(value = "/holiday/{empNo}")
    @ResponseBody
    public HolidayDto HolidayInfo(@PathVariable String empNo) {
        logger.debug(empNo);

        HolidayDto result = holidayService.getEmpInfo(empNo);

        return result;
    }

    // 휴가 신청 기능
    @PostMapping(value = "/holiday")
    @ResponseBody
    public ResponseModel ApplyHoli(@RequestBody ApplyHoliDto applyHoliDto){

        ResponseModel result = holidayService.applyHoli(applyHoliDto);

        return result;
    }

    // 결재 조회 기능
    @GetMapping(value = "/team/holiday/{team}/{empNo}")
    @ResponseBody
    public List<DetailHolidayDto> CheckApproval(@PathVariable String team, @PathVariable String empNo){
        logger.debug(empNo);

        List<DetailHolidayDto> result = (List<DetailHolidayDto>) holidayService.checkApproval(team, empNo);

        return result;
    }


    // 승인 및 반려 기능
    @PutMapping(value = "/team/holiday")
    @ResponseBody
    public ResponseModel ApprovalHoli(@RequestBody HoliParamDto holiParamDto){

        ResponseModel result = holidayService.approvalHoli(holiParamDto);

        return result;
    }

    // 휴가 신청 취소 기능
    @DeleteMapping(value = "/holiday")
    @ResponseBody
    public ResponseModel CancelHoli(@RequestBody HoliParamDto holiParamDto){
        ResponseModel result = holidayService.cancelHoli(holiParamDto);
        return result;
    }

}
