package com.mas.medicalservices.model;

import org.jetbrains.annotations.NotNull;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Entity
@Table(name = "Receptionist")
@PrimaryKeyJoinColumn(name = "id_receptionist")
public class Receptionist extends Employee{


    public Receptionist(Integer id,@NotNull String name, @NotNull String lastName, String email, String phoneNumber, Double salary, Date employmentDate,Date birthDate) {
        super(id,name, lastName, email, phoneNumber, salary, employmentDate,birthDate);
    }

    public Receptionist() {

    }

    @Override
    public double getExperience() {
        double days = TimeUnit.DAYS.convert(Math.abs(this.getEmploymentDate().getTime() - new Date().getTime()),TimeUnit.MILLISECONDS);

        return days/365;
    }

    @Override
    public void setSalary(Double salary) throws Exception {
        this.salary = salary;
    }
}
