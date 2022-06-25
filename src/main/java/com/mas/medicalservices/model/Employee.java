package com.mas.medicalservices.model;

import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Table(name = "Employee")
@PrimaryKeyJoinColumn(name = "id_employee")
public abstract class Employee extends Person{

    private static final Integer STANDARD_SALARY_RAISE = 100;

    private static final Integer BONUS_FOR_5_YEARS_PLUS = 3000;

    @NotNull
    @Column(name = "salary")
    protected Double salary;

    @NotNull
    @Column(name = "employment_date")
    private Date employmentDate;

    public Employee(Integer id,@NotNull String name, @NotNull String lastName, String email, String phoneNumber, Double salary, Date employmentDate,Date birthDate) {
        super(id,name, lastName, email, phoneNumber,birthDate);
        this.salary = salary;
        this.employmentDate = employmentDate;
    }

    public Employee() {

    }

    //NOTE przeciązenie
    public void inscreseSalary(){
        salary +=  STANDARD_SALARY_RAISE ;
    }

    public void increaseSalary(Integer raise){
        salary += raise;
    }

    public void increaseSalary(Double percent, Integer raise){
        salary = salary + salary*percent + raise;
    }


    public Date getEmploymentDate() {
        return employmentDate;
    }


    public abstract double getExperience();

    public Double getSalary() {
        return salary;
    }

    public abstract void setSalary(Double salary) throws Exception;

    // atr. pochodny
    public Double anuualSalary(){

        if(this.getExperience() >= 5.0)
            return 12*salary + BONUS_FOR_5_YEARS_PLUS;

        return  salary * 12 ;
    }

}
