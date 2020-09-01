package com.cal_holi.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainService {

    //스프링이 제공하는, new 사용x
    @Autowired
    EmpMapper empMapper;

    public GetEmpInfoDto empInfo(String empNo){
        GetEmpInfoDto result = empMapper.getInfo();
        return result;
    }

}


