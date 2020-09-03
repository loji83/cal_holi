package com.ksmartech.holiday.mapper;

import com.ksmartech.holiday.model.DetailHolidayDto;
import com.ksmartech.holiday.model.HolidayDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DetailMapper {

    List<DetailHolidayDto> getInfo(String empNo);

    HolidayDto getEmpInfo(String empNo);


}


