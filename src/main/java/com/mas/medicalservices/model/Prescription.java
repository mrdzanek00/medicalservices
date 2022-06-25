package com.mas.medicalservices.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Entity
@Table( name = "Prescription")
public class Prescription {

    //TODO atr. klasowy
    private static final String CLINIC_NAME = "CLINIC2137";

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column( name = "id_prescription")
    private Integer idPrescription;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonBackReference
    @JoinColumn(name = "id_patient")
    private Patient patient;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_doctor")
    @JsonBackReference
    private Doctor doctor;

    @Nullable
    @Column( name = "info_pharmacy")
    private String infoPharmacy ;

    @JoinColumn(name = "id_prescription")
    @JsonManagedReference
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<HealMethod> healMethodList = new ArrayList<>();

    public List<HealMethod> getHealMethodList() {
        return healMethodList;
    }

    public void setHealMethodList(List<HealMethod> healMethodList) {
        this.healMethodList = healMethodList;
    }

    public void addHealMethod(HealMethod healMethod){
        healMethodList.add(healMethod);
    }

    public Integer getIdPrescription() {
        return idPrescription;
    }

    public void setIdPrescription(Integer idPrescription) {
        this.idPrescription = idPrescription;
    }

    public Patient getPatient() {
        return patient;
    }


    public Doctor getDoctor() {
        return doctor;
    }


    public String getInfoPharmacy() {
        return infoPharmacy;
    }

    public void setInfoPharmacy(String infoPharmacy) {
        this.infoPharmacy = infoPharmacy;
    }

      public void setDoctor(Doctor doctor) {
        if(this.doctor!=null) {
            // usuwam stare powiązanie
            this.doctor.getPrescriptions().remove(this);
        }
            // ustawiam nowego doktora
            this.doctor = doctor;
            // dodaje mu powiązanie
            this.doctor.addPrescription(this);

    }

    public void setPatient(Patient patient) {
        if(this.patient!=null) {
            // usuwam stare powiązanie
            this.patient.getPrescriptions().remove(this);
        }
        // ustawiam nowego doktora
        this.patient = patient;
        // dodaje mu powiązanie
        this.patient.addPrescription(this);

    }



   /* //NOTE asocjacja KWALIFIKOWANA
    public void addMedicineQualif(Medicine medicine) {
        if(!medicineQualif.containsKey(medicine.getName())){
            medicineQualif.put(medicine.getName(),medicine);
        //    medicine.addPrescription(this);
        }
    }

    public Medicine findMedicineQualif(String name) throws Exception{
        if(!medicineQualif.containsKey(name))
            throw new Exception("Medicine with name: "+ name + "is not on this prescription");

        return medicineQualif.get(name);
    }*/

}
