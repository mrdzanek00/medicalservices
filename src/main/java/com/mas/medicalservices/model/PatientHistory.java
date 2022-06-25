package com.mas.medicalservices.model;


import javax.persistence.*;
import java.util.Date;

@Embeddable
public class PatientHistory {

    private Date firstVisitDate;

    private String description;

    public Date getFirstVisitDate() {
        return firstVisitDate;
    }

    public void setFirstVisitDate(Date firstVisitDate) {
        this.firstVisitDate = firstVisitDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
