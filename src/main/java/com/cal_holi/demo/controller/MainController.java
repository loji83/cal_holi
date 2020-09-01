package com.cal_holi.demo.controller;

import com.cal_holi.demo.service.DetailHolidayService;
import com.cal_holi.demo.model.DetailHolidayDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class MainController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    DetailHolidayService detailHolidayService;

    @GetMapping(value = "/detailHolidayInfo/{empNo}")
    @ResponseBody
    public List<DetailHolidayDto> detailHolidayInfo(@PathVariable String empNo){
        logger.debug(empNo);

        List<DetailHolidayDto> result= (List<DetailHolidayDto>)detailHolidayService.empInfo(empNo);

        return result;
    }

}