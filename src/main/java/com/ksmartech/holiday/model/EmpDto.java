package com.ksmartech.holiday.model;

//사원 정보 조회를 위한 모델
public class EmpDto {
    private String joinDate;
    private String name;
    private String birthday;
    private String position;
    private String team;
    private String rank;
    private String state;

    @Override
    public String toString() {
        return "EmpDto{" +
                "joinDate='" + joinDate + '\'' +
                ", name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                ", position='" + position + '\'' +
                ", team='" + team + '\'' +
                ", rank='" + rank + '\'' +
                ", state='" + state + '\'' +
                '}';
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
