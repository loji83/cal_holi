package com.ksmartech.holiday.model;

import java.util.Date;

public class ApplyHoliDto {
    private String empNo;
    private Date startDate;
    private Date endDate;
    private String holiType;
    private double duration;

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getHoliType() {
        return holiType;
    }

    public void setHoliType(String holiType) {
        this.holiType = holiType;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "ApplyHoliDto{" +
                "empNo='" + empNo + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", holiType='" + holiType + '\'' +
                ", duration=" + duration +
                '}';
    }
}
