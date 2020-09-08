package com.ksmartech.holiday.mapper;

import com.ksmartech.holiday.model.*;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface EmployeeMapper {

    EmpDto showEmpInfo(String empNo);

    int newEmp(EmpDto empDto);

    int resignEmp(String empNo);
}


