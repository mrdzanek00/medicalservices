package com.mas.medicalservices.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

//NOTE Kompozycja
@Entity
@Table(name = "Visit")
public class Visit {

    private static final Set<Visit> extent  = new HashSet<>();

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_visit")
    private Integer id_visit;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="id_doctor", nullable=false)
    @JsonIgnore
    private Doctor doctor;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="id_patient", nullable=false)
    @JsonIgnore
    private Patient patient;

    @NotNull
    @Column(name = "begin_date")
    private Date beginDate;

    @NotNull
    @Column(name = "duration")
    private Integer duration;


    public Visit() {

    }

    public Visit(Integer id_visit, Doctor doctor, Patient patient, @NotNull Date beginDate, @NotNull Integer duration) {
        this.id_visit = id_visit;
        this.doctor = doctor;
        this.patient = patient;
        this.beginDate = beginDate;
        this.duration = duration;
    }

    public Visit(Doctor doctor, Patient patient, @NotNull Date beginDate, @NotNull Integer duration) {
        this.doctor = doctor;
        this.patient = patient;
        this.beginDate = beginDate;
        this.duration = duration;
    }

    public void setIdVisit(int idVisit) {
        this.id_visit = idVisit;
    }


    public int getIdVisit() {
        return id_visit;
    }


    public void setDoctor(Doctor doctor){
        if(this.doctor!=null) {
            // usuwam stare powiązanie
            this.doctor.getVisits().remove(this);
        }
        // ustawiam nowego doktora
        this.doctor = doctor;
        // dodaje mu powiązanie
        this.doctor.addVisit(this);

    }

    public void setPatient(Patient patient){
        if(this.patient!=null) {
            // usuwam stare powiązanie
            this.patient.getVisits().remove(this);
        }
        // ustawiam nowego doktora
        this.patient = patient;
        // dodaje mu powiązanie
        this.patient.addVisit(this);

    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Patient getPatient() {
        return patient;
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
