package com.ksmartech.holiday.mapper;

import com.ksmartech.holiday.model.ApplyHoliDto;
import com.ksmartech.holiday.model.DetailHolidayDto;
import com.ksmartech.holiday.model.EmpDto;
import com.ksmartech.holiday.model.HolidayDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HolidayMapper {

    List<DetailHolidayDto> getInfo(String empNo);

    HolidayDto getEmpInfo(String empNo);

    int applyEmp(ApplyHoliDto applyHoliDto);

}




