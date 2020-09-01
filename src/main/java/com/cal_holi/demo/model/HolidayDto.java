package com.cal_holi.demo.model;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class HolidayDto {

    private String totalDays;
    private String cntUsed;
    private String remain;

    public String getTotalDays() {
        return totalDays;
    }

    public void setTotalDays(String totalDays) {
        this.totalDays = totalDays;
    }

    public String getCntUsed() {
        return cntUsed;
    }

    public void setCntUsed(String cntUsed) {
        this.cntUsed = cntUsed;
    }

    public String getRemain() {
        return remain;
    }

    public void setRemain(String remain) {
        this.remain = remain;
    }

    @Override
    public String toString() {
        return "HolidayDto{" +
                "totalDays='" + totalDays + '\'' +
                ", cntUsed='" + cntUsed + '\'' +
                ", remain='" + remain + '\'' +
                '}';
    }
}
