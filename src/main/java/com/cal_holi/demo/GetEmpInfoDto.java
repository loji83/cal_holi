package com.cal_holi.demo;

public class GetEmpInfoDto {
    private String emp_no;
    private String join_date;
    private String name;
    private String position;
    private String team;

    public String getEmp_no() {
        return emp_no;
    }

    public void setEmp_no(String emp_no) {
        this.emp_no = emp_no;
    }

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

    @Override
    public String toString() {
        return "DataModel{" +
                "emp_no='" + emp_no + '\'' +
                ", join_date='" + join_date + '\'' +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", team='" + team + '\'' +
                '}';

        }
    }
