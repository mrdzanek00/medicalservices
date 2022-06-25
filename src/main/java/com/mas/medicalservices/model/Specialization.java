package com.mas.medicalservices.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "Specialization")
public class Specialization {

    @Column( name = "spec_name")
    private String specName;

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    @Id
    public String getSpecName() {
        return specName;
    }

    @Column( name = "description")
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
