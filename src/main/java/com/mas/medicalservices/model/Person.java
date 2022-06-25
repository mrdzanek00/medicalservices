package com.mas.medicalservices.model;

import org.intellij.lang.annotations.Pattern;
import org.jetbrains.annotations.NotNull;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.Date;

@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public abstract class Person {

    @Id
    @Column(name = "id_person")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private  Integer id_person ;

    @NotNull
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Column(name = "last_name")
    private String lastName;

    @Nullable
    @Email
    @Pattern("[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$")
    @Column(name = "email")
    private String email;

    //TODO Atr. opcjonalny
    @Nullable
    @Size(min= 9, max=9)
    @Column(name = "phone_number")
    private String phoneNumber;


    @Column(name = "birth_date")
    @Nullable
    private Date birthDate;

    public Person(Integer id,@NotNull String name, @NotNull String lastName, @Nullable String email, @Nullable String phoneNumber,Date birthDate) {
        this.id_person = id;
        this.firstName = name;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
    }

    public Person() {

    }


    public Integer getId_person() {
        return id_person;
    }

    public void setId_person(Integer id_person) {
        this.id_person = id_person;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Nullable
    public String getEmail() {
        return email;
    }

    public void setEmail(@Nullable String email) {
        this.email = email;
    }

    @Nullable
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(@Nullable String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Nullable
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(@Nullable Date birthDate) {
        this.birthDate = birthDate;
    }


}
