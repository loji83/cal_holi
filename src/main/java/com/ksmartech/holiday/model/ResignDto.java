package com.ksmartech.holiday.model;

public class ResignDto {
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "ResignDto{" +
                "state='" + state + '\'' +
                '}';
    }
}
