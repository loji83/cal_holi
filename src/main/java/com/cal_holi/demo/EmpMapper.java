package com.cal_holi.demo;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

@Mapper
public interface EmpMapper {
    GetEmpInfoDto getInfo();

}
