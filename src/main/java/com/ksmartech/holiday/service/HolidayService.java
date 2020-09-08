package com.ksmartech.holiday.service;

import com.ksmartech.holiday.mapper.HolidayMapper;
import com.ksmartech.holiday.model.DetailHolidayDto;
import com.ksmartech.holiday.model.EmpDto;
import com.ksmartech.holiday.model.HolidayDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HolidayService {

    @Autowired
    HolidayMapper holidayMapper;

    public List<DetailHolidayDto> empInfo(String empNo){
        List<DetailHolidayDto> result = (List<DetailHolidayDto>) holidayMapper.getInfo(empNo);
        return result;
    }

    public HolidayDto getEmpInfo(String empNo){
        HolidayDto result = holidayMapper.getEmpInfo(empNo);
        return result;
    }


}
