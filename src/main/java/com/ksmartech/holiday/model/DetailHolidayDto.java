package com.ksmartech.holiday.model;

//  사용한 연차 날짜 목록 조회를 위한 모델
public class DetailHolidayDto {
    private String holiDate;
    private String duration;
    private String remain;

    public String getHoliDate() {
        return holiDate;
    }

    public void setHoliDate(String holiDate) {
        this.holiDate = holiDate;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getRemain() {
        return remain;
    }

    public void setRemain(String remain) {
        this.remain = remain;
    }

    @Override
    public String toString() {
        return "DetailHolidayDto{" +
                "holiDate='" + holiDate + '\'' +
                ", duration='" + duration + '\'' +
                ", remain='" + remain + '\'' +
                '}';
    }
}
