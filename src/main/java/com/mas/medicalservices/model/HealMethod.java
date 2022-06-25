package com.mas.medicalservices.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.persistence.*;

@Entity
@Table( name = "heal_method")
public class HealMethod {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column( name = "id_heal_method")
    private Integer idHealMethod;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonBackReference
    @JoinColumn(name = "id_medicine")
    private Medicine medicine;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonBackReference
    @JoinColumn(name = "id_prescription")
    private Prescription prescription;

    @NotNull
    @Column( name = "dose")
    private String dose;

    @NotNull
    @Column( name = "taking_time")
    private String taking_time;

    @Nullable
    @Column( name = "remark")
    private String remark;

    public HealMethod(Integer idHealMethod, Medicine medicine, Prescription prescription, @NotNull String dose, @NotNull String taking_time, @Nullable String remark) {
        this.idHealMethod = idHealMethod;
        this.medicine = medicine;
        this.prescription = prescription;
        this.dose = dose;
        this.taking_time = taking_time;
        this.remark = remark;
    }

    public Integer getIdHealMethod() {
        return idHealMethod;
    }

    public void setIdHealMethod(Integer idHealMethod) {
        this.idHealMethod = idHealMethod;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public String getTaking_time() {
        return taking_time;
    }

    public void setTaking_time(String taking_time) {
        this.taking_time = taking_time;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public HealMethod() {

    }


}
