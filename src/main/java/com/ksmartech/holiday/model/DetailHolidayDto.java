package com.ksmartech.holiday.model;

// 휴가 세부내용 조회를 위한 모델
public class DetailHolidayDto {
    private String holiNo;
    private String startDate;
    private String endDate;
    private String duration;
    private String holiType;
    private String state;

    public String getHoliNo() {
        return holiNo;
    }

    public void setHoliNo(String holiNo) {
        this.holiNo = holiNo;
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

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getHoliType() {
        return holiType;
    }

    public void setHoliType(String holiType) {
        this.holiType = holiType;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "DetailHolidayDto{" +
                "holNo='" + holiNo + '\'' +
                "startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", duration='" + duration + '\'' +
                ", holiType='" + holiType + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
