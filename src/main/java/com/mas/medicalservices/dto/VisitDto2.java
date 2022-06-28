package com.mas.medicalservices.dto;

import java.util.Date;

public class VisitDto2 {
/*
    private Integer id_visit;

    private Integer id_doctor;

    private Integer id_patient;
*/

    private String dname;

    private String dlast;

    private String pname;

    private String plast;

    private Date begin_date;

    private Integer duration;

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDlast() {
        return dlast;
    }

    public void setDlast(String dlast) {
        this.dlast = dlast;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPlast() {
        return plast;
    }

    public void setPlast(String plast) {
        this.plast = plast;
    }

    public Date getBegin_date() {
        return begin_date;
    }

    public void setBegin_date(Date begin_date) {
        this.begin_date = begin_date;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }
}
