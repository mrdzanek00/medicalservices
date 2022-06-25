package com.mas.medicalservices.model;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table( name = "Internship")
public class Internship {

    @Id
    @Column(name = "id_internship")
    private Integer idIntership;

    @NotNull
    @Column(name = "start_date")
    private Date startDate;

    @Nullable
    @Column(name = "end_date")
    private Date endDate;

    public Integer getIdIntership() {
        return idIntership;
    }

    public void setIdIntership(Integer idIntership) {
        this.idIntership = idIntership;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
