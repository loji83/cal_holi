package com.ksmartech.holiday.service;


import com.ksmartech.holiday.mapper.MainMapper;
import com.ksmartech.holiday.model.DetailHolidayDto;
import com.ksmartech.holiday.model.HolidayDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainService {

    @Autowired
    MainMapper mainMapper;

    public List<DetailHolidayDto> empInfo(String empNo){
        List<DetailHolidayDto> result = (List<DetailHolidayDto>) mainMapper.getInfo(empNo);
        return result;
    }

    public HolidayDto getEmpInfo(String empNo){
        HolidayDto result2 = mainMapper.getEmpInfo(empNo);
        return result2;
    }

}





