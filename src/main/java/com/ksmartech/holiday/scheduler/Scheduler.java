package com.ksmartech.holiday.scheduler;

import com.ksmartech.holiday.mapper.HolidayMapper;
import com.ksmartech.holiday.model.DetailHolidayDto;
import com.ksmartech.holiday.model.ResponseModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    HolidayMapper holidayMapper;

    @Scheduled(fixedDelay = 2000, initialDelay = 3000)
    private void scheduleTest(DetailHolidayDto detailHolidayDto) {
        // logger.debug("hello");

        ResponseModel responseModel = new ResponseModel();

        if(!isHolidayState(detailHolidayDto.getState())){
            responseModel.setCode("0100");
            responseModel.setMessage("It's impossible to change this holiday's state.");
        } else {
            detailHolidayDto.setState("사용");
            responseModel.setCode("0000");
            responseModel.setMessage("Success");
        }
        logger.debug(String.valueOf(responseModel));
    }

    private boolean isHolidayState(String state) {

        String rank = holidayMapper.isHoliState(state);

        if (rank.equals("승인")) {
            return true;
        }
        return false;
    }
}

