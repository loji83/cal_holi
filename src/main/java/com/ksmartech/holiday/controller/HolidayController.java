package com.ksmartech.holiday.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.ksmartech.holiday.model.*;
import com.ksmartech.holiday.service.HolidayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
public class HolidayController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    HolidayService holidayService;


    // home화면
    @GetMapping(value = "/{empNo}")
    public String init(Model model, @PathVariable String empNo){

        HolidayDto holidayDto = holidayService.cntUsedHoli(empNo);
        model.addAttribute("holiCnt", holidayDto);


        model.addAttribute("holiList",holidayService.holiList(empNo));
        logger.debug("" + model);

        return "index.jsp";
    }

    // 팀장의 결재 화면
    @GetMapping(value = "/{team}/{empNo}")
    public String Approval(Model model, @PathVariable String team, @PathVariable String empNo) {
        logger.debug("empNo : "+empNo);
        logger.debug("team : "+team);

        ResponseModel result = holidayService.checkApproval(team, empNo);
        logger.debug("!!!"+result.toString());
        model.addAttribute("approvalList", result.getData());

        logger.debug(""+model);
        return "approval.jsp";
    }



    // 휴가 내역 조회 기능
    @GetMapping(value = "/detailHolidays/{empNo}")
    public List<DetailHolidayDto> DetailHolidayInfo(Model model, @RequestBody /* @PathVariable*/ String empNo) {
        logger.debug("empNo : " + empNo);

        List<DetailHolidayDto> result = holidayService.holiList(empNo);
        logger.debug(result + "");

        return result;
    }


    // 잔여일 조회 기능
    @GetMapping(value = "/holiday/{empNo}")

    public HolidayDto HolidayInfo(@PathVariable String empNo) {
        logger.debug(empNo);

        HolidayDto result = holidayService.cntUsedHoli(empNo);

        return result;
    }


    // 휴가 신청 기능
    @PostMapping(value = "/holiday")
    @ResponseBody
    public ResponseModel ApplyHoli(@RequestBody ApplyHoliDto applyHoliDto) {

        ResponseModel result = holidayService.applyHoli(applyHoliDto);

        return result;
    }


    // 결재 조회 기능
    @GetMapping(value = "/team/holiday/{team}/{empNo}")
    @ResponseBody
    public ResponseModel CheckApproval(@PathVariable String team, @PathVariable String empNo) {
        logger.debug(empNo);

        ResponseModel result = holidayService.checkApproval(team, empNo);

        return result;
    }


    // 승인 및 반려 기능
    @PutMapping(value = "/team/holiday")
    @ResponseBody
    public ResponseModel ApprovalHoli(@RequestBody HoliParamDto holiParamDto) {

        ResponseModel result = holidayService.approvalHoli(holiParamDto);

        return result;
    }


    // 휴가 신청 취소 기능
    @DeleteMapping(value = "/holiday")
    @ResponseBody
    public ResponseModel CancelHoli(@RequestBody HoliParamDto holiParamDto) {
        ResponseModel result = holidayService.cancelHoli(holiParamDto);
        return result;
    }

    // 스케줄러 동작 확인
    @GetMapping(value = "/batch")
    @ResponseBody
    public String test() {
        holidayService.scheduleTest();

        return "ok";
    }
}
