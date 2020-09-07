package com.ksmartech.holiday.model;

//사원 정보 조회를 위한 모델
public class EmpDto {
    private String join_date;
    private String name;
    private String birthday;
    private String position;
    private String team;
    private String rank;


    public String getJoin_date() {
        return join_date;
    }

    public void setJoin_date(String join_date) {
        this.join_date = join_date;
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

    @Override
    public String toString() {
        return "EmpDto{" +
                "join_date='" + join_date + '\'' +
                ", name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                ", position='" + position + '\'' +
                ", team='" + team + '\'' +
                ", rank='" + rank + '\'' +
                '}';
    }
}
