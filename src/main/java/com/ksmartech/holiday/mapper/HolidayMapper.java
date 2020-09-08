package com.ksmartech.holiday.mapper;

import com.ksmartech.holiday.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HolidayMapper {

    List<DetailHolidayDto> getInfo(String empNo);

    HolidayDto getEmpInfo(String empNo);

    int applyEmp(ApplyHoliDto applyHoliDto);

    List<DetailHolidayDto> checkApproval(String team, String empNo);

    int rejectHoli(String holiNo, String empNo);

    int approvalHoli(String holiNo, String empNo);


}




