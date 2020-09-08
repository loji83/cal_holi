package com.ksmartech.holiday.model;

public class HoliParamDto {
    private String state;
    private String empNo;
    private String holiNo;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public String getHoliNo() {
        return holiNo;
    }

    public void setHoliNo(String holiNo) {
        this.holiNo = holiNo;
    }

    @Override
    public String toString() {
        return "HoliParamDto{" +
                "state='" + state + '\'' +
                ", empNo='" + empNo + '\'' +
                ", holiNo='" + holiNo + '\'' +
                '}';
    }
}
