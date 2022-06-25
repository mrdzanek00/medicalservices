package com.mas.medicalservices.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.persistence.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.util.stream.Collectors;

@Entity
@Table(name = "Doctor")
@PrimaryKeyJoinColumn(name = "id_doctor")
public class Doctor extends Employee {


    private static final Map<String, Doctor> doctors = new HashMap<>();

    @NotNull
    @Column(name = "license_number")
    private String licenseNumber;

    @NotNull
    @Column(name = "experience")
    private Double experience;

    @Nullable
    @ManyToOne
    @JoinColumn(name = "specialization_name")
    private Specialization specialization;

    @Nullable
    @ManyToOne
    @JoinColumn(name = "id_internship")
    private Internship internship;

    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "id_doctor")
    private List<Visit> visits = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_doctor")
    private List<Prescription> prescriptions = new ArrayList<>();

    private static final Double minimalSalary = 5000.00;

    private static final Double maximumSalary = 30000.00;


    public Doctor(Integer personId, @NotNull String name, @NotNull String lastName, String email, String phoneNumber, Double salary, Date employmentDate, String licenseNumber, Double expYears, Date birthDate, Specialization specialization) throws Exception {
        super(personId, name, lastName, email, phoneNumber, salary, employmentDate, birthDate);

        if (salary < minimalSalary) {
            throw new Exception("Salary is too low");
        }
        if (salary > maximumSalary) {
            throw new Exception("Salary is too high");
        }

        if (doctors.containsKey(licenseNumber)) {
            throw new Exception("License number is already in use");
        } else {
            doctors.put(licenseNumber, this);
        }

        this.licenseNumber = licenseNumber;
        this.experience = expYears;
        this.specialization = specialization;
    }

    public Doctor(Integer personId, @NotNull String name, @NotNull String lastName, String email, String phoneNumber, Double salary, Date employmentDate, String licenseNumber, Double expYears, Date birthDate) throws Exception {
        super(personId, name, lastName, email, phoneNumber, salary, employmentDate, birthDate);

        if (salary < minimalSalary) {
            throw new Exception("Salary is too low");
        }
        if (salary > maximumSalary) {
            throw new Exception("Salary is too high");
        }

        if (doctors.containsKey(licenseNumber)) {
            throw new Exception("License number is already in use");
        } else {
            doctors.put(licenseNumber, this);
        }

        this.licenseNumber = licenseNumber;
        this.experience = expYears;
    }

    public Doctor(Integer personId, @NotNull String name, @NotNull String lastName, String email, String phoneNumber, Double salary, Date employmentDate, String licenseNumber, Double expYears, Date birthDate, Internship internship) throws Exception {
        super(personId, name, lastName, email, phoneNumber, salary, employmentDate, birthDate);

        if (salary < minimalSalary) {
            throw new Exception("Salary is too low");
        }
        if (salary > maximumSalary) {
            throw new Exception("Salary is too high");
        }

        if (doctors.containsKey(licenseNumber)) {
            throw new Exception("License number is already in use");
        } else {
            doctors.put(licenseNumber, this);
        }

        this.licenseNumber = licenseNumber;
        this.experience = expYears;
        this.internship = internship;
    }

    public Doctor() {

    }


    //NOTE
    @Override
    public double getExperience() {

        double days = TimeUnit.DAYS.convert(Math.abs(this.getEmploymentDate().getTime() - new Date().getTime()), TimeUnit.MILLISECONDS);

        return days / 365 + experience;

    }

    @Override
    public void setSalary(Double salary) throws Exception {
        if (salary > maximumSalary) {
            throw new Exception("Salary is too high");
        }
        if (salary < minimalSalary) {
            throw new Exception("Salary is too low");

        }
        this.salary = salary;
    }

    public String getLicenseNumber() {
        System.out.println("SET LICENSE " + licenseNumber);
        if (!doctors.containsKey(licenseNumber)) {
            doctors.put(licenseNumber, this);
            System.out.println("DODAJE BO NIE MA " + licenseNumber);

        }
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) throws Exception {
        System.out.println("SET LICENSE " + licenseNumber);

        if (doctors.containsKey(licenseNumber)) {
            throw new Exception("License number is already in use");
        } else {
            doctors.put(licenseNumber, this);
        }
        this.licenseNumber = licenseNumber;
    }

    public void setVisits(List<Visit> visits) {
        this.visits = visits;
    }

    public void addVisit(Visit visit) {
        if (!visits.contains(visit)) {
            visit.setDoctor(this);
            visits.add(visit);

        }
    }

    public List<Visit> getVisits() {
        return visits;
    }

    public Specialization getSpecialization() {
        return specialization;
    }


    //TODO XOR
    public void setSpecialization(Specialization specialization) throws Exception {
        if (internship != null) {
            throw new Exception("Doctor is on internship, cant have be specialist!");
        }
        this.specialization = specialization;
    }

    public Internship getInternship() {
        return internship;
    }

    //TODO XOR
    public void setInternship(Internship internship) throws Exception {
        if (specialization != null) {
            throw new Exception("Doctor is a specialist, cant have internship!");
        }
        this.internship = internship;
    }

    public List<Prescription> getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(List<Prescription> prescriptions) {
        this.prescriptions = prescriptions;
    }

    public void addPrescription(Prescription prescription) {
        if (!prescriptions.contains(prescription)) {
            prescription.setDoctor(this);
            prescriptions.add(prescription);
        }
    }

    /*  public List<Prescription> getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(List<Prescription> prescriptions) {
        this.prescriptions = prescriptions;
    }

    public void addPrescription(Prescription prescription){

        if(!prescriptions.contains(prescription)){
            prescription.setDoctor(this);
            prescriptions.add(prescription);
        }
    }*/



   /*

    }*/


        //TODO SUBSET
        @JsonIgnore
        public Visit getNextVisit () {

            List<Visit> comingVisits = visits.stream().filter(visit -> new Date().before(visit.getBeginDate())).collect(Collectors.toList());
            if (comingVisits.size() == 0) {
                throw new NoSuchElementException("Doctor have no incoming visits!");
            }

            comingVisits.sort((visit1, visit2) -> {
                if (visit1.getBeginDate().before(visit2.getBeginDate()))
                    return 1;
                else
                    return 0;
            });

            return comingVisits.get(0);

        }


    }

