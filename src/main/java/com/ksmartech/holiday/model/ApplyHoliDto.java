package com.ksmartech.holiday.model;

public class ApplyHoliDto {
    private String empNo;
    private String startDate;
    private String endDate;
    private String holiType;
    private String duration;

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getHoliType() {
        return holiType;
    }

    public void setHoliType(String holiType) {
        this.holiType = holiType;
    }

    @Override
    public String toString() {
        return "ApplyHoliDto{" +
                "empNo='" + empNo + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", holiType='" + holiType + '\'' +
                ", duration='" + duration + '\'' +
                '}';
    }
}
