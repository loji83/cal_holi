package com.cal_holi.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class MainController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    MainService mainService;
    @GetMapping(value = "/empInfo/{empNo}")
    @ResponseBody
    public GetEmpInfoDto empInfo(@PathVariable String empNo){
        logger.debug(empNo);


        GetEmpInfoDto result= mainService.empInfo(empNo);

        return result;
    }

}
