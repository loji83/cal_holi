package com.ksmartech.holiday.mapper;

import com.ksmartech.holiday.model.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MainMapper {

    List<DetailHolidayDto> getInfo(String empNo);

    HolidayDto getEmpInfo(String empNo);

    EmpDto showEmpInfo(String empNo);

    int newEmp(EmpDto empDto);

    int resignEmp(String empNo);
}


