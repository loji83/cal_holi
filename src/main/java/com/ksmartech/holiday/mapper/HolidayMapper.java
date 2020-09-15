package com.ksmartech.holiday.mapper;

import com.ksmartech.holiday.model.*;
import org.apache.ibatis.annotations.Mapper;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

@Mapper
public interface HolidayMapper {

    ArrayList<DetailHolidayDto> getHoliList(String empNo);

    HolidayDto cntUsedHoli(String empNo);

    int applyHoli(ApplyHoliDto applyHoliDto);

    ArrayList<DetailHolidayDto> checkApproval(String team, String empNo);

    int approvalHoli(HoliParamDto holiParamDto);

    int cancelHoli(HoliParamDto holiParamDto);

    int changeApprovalHoli(String strDate);

    ArrayList<DetailHolidayDto> getUpdatedHoli(String strDate);

    int calTotalHoliInfo(DetailHolidayDto detailHolidayDto);
}




