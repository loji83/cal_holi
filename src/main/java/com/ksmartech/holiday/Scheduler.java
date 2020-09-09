package com.ksmartech.holiday;

import com.ksmartech.holiday.mapper.HolidayMapper;
import com.ksmartech.holiday.model.DetailHolidayDto;
import com.ksmartech.holiday.model.ResponseModel;
import com.ksmartech.holiday.service.HolidayService;
import com.ksmartech.holiday.mapper.HolidayMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {

    @Autowired
    HolidayService holidayService;

    @Autowired
    HolidayMapper holidayMapper;

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Scheduled(fixedDelay = 2000, initialDelay = 2000)
    private void scheduleTest() {
        logger.debug("Scheduler 내부");
        // 도대체..코드... 위치가....... 어떻게.. 어디에...........

    }
}
