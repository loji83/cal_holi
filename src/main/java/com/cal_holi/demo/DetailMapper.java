package com.cal_holi.demo;

import com.cal_holi.demo.model.DetailHolidayDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DetailMapper {
    List<DetailHolidayDto> getInfo(String empNo);

}
