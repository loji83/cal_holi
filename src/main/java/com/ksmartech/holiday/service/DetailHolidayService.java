package com.ksmartech.holiday.service;


import com.ksmartech.holiday.DetailMapper;
import com.ksmartech.holiday.model.DetailHolidayDto;
import com.ksmartech.holiday.model.HolidayDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailHolidayService {

    @Autowired
    DetailMapper detailMapper;

    public List<DetailHolidayDto> empInfo(String empNo){
        List<DetailHolidayDto> result = (List<DetailHolidayDto>) detailMapper.getInfo(empNo);
        return result;
    }

    public HolidayDto getEmpInfo(String empNo){
        HolidayDto result2 = detailMapper.getEmpInfo(empNo);
        return result2;
    }

}





