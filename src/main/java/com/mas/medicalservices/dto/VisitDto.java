package com.mas.medicalservices.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mas.medicalservices.model.Doctor;
import com.mas.medicalservices.model.Patient;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.util.Date;

public class VisitDto {


    private Integer id_visit;

    private Integer id_doctor;

    private Integer id_patient;

    private Date beginDate;

    private Integer duration;


    public Integer getId_visit() {
        return id_visit;
    }

    public void setId_visit(Integer id_visit) {
        this.id_visit = id_visit;
    }

    public Integer getId_doctor() {
        return id_doctor;
    }

    public void setId_doctor(Integer id_doctor) {
        this.id_doctor = id_doctor;
    }

    public Integer getId_patient() {
        return id_patient;
    }

    public void setId_patient(Integer id_patient) {
        this.id_patient = id_patient;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }
}
