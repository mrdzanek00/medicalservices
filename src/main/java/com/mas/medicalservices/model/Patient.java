package com.mas.medicalservices.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Patient")
@PrimaryKeyJoinColumn(name = "id_patient")
public class Patient extends Person{

   //@ManyToMany
   // private List<VisitV2> visits = new ArrayList<>();

    //bag
  //  private List<Prescription> prescriptions = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "id_patient")
    private List<Visit> visits = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_patient")
    @JsonManagedReference
    private List<Prescription> prescriptions = new ArrayList<>();

    @NotNull
    @Column(name = "PESEL")
    private Integer PESEL;

    @NotNull
    @Column(name = "register_date")
    private Date registerDate;

    @Embedded
    @AttributeOverrides( {
            @AttributeOverride(name="description", column = @Column(name="description") ),
            @AttributeOverride(name="firstVisitDate", column = @Column(name="first_visit_date") )
    } )
    private PatientHistory patientHistory;

    public PatientHistory getPatientHistory() {
        return patientHistory;
    }

    public void setPatientHistory(PatientHistory patientHistory) {
        this.patientHistory = patientHistory;
    }

    public Patient(Integer id, @NotNull String name, @NotNull String lastName, String email, String phoneNumber, Date birthDate, @NotNull int PESEL, @NotNull Date registerDate) {
        super(id,name, lastName, email, phoneNumber, birthDate);
        this.PESEL = PESEL;
        this.registerDate = registerDate;
    }

    public Patient() {

    }

    public int getPESEL() {
        return PESEL;
    }

    public void setPESEL(int PESEL) {
        this.PESEL = PESEL;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public void addVisit(Visit visit){
        if(!visits.contains(visit)){
            visit.setPatient(this);
            visits.add(visit);

        }
    }

    public List<Visit> getVisits() {
        return visits;
    }

    public List<Prescription> getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(List<Prescription> prescriptions) {
        this.prescriptions = prescriptions;
    }

    public void addPrescription(Prescription prescription) {
        if (!prescriptions.contains(prescription)) {
            prescription.setPatient(this);
            prescriptions.add(prescription);
        }
    }

/*    public void addVisit(VisitV2 visit){
        if(!visits.contains(visit))
            visits.add(visit);

    }

    public List<VisitV2> getVisits() {
        return visits;
    }


    public List<Prescription> getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(List<Prescription> prescriptions) {
        this.prescriptions = prescriptions;
    }*/

    /*public void addPrescription(Prescription prescription){

        if(!prescriptions.contains(prescription)){
            prescription.setPatient(this);
            prescriptions.add(prescription);
        }
    }*/


}
