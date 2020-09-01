package com.cal_holi.demo.service;


import com.cal_holi.demo.DetailMapper;
import com.cal_holi.demo.model.DetailHolidayDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailHolidayService {

    //스프링이 제공하는, new 사용x
    @Autowired
    DetailMapper detailMapper;

    public List<DetailHolidayDto> empInfo(String empNo){
        List<DetailHolidayDto> result = (List<DetailHolidayDto>) detailMapper.getInfo(empNo);
        return result;
    }

}


