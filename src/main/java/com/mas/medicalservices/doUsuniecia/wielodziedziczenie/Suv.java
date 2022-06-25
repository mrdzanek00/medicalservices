package com.mas.medicalservices.doUsuniecia.wielodziedziczenie;

public class Suv extends Car {

    private Boolean is4x4;

    private Integer numberOfSeats;

    public Suv(String name, Integer vintage, String mark,Boolean is4x4,Integer numberOfSeats) {
        super(name, vintage, mark);
        this.is4x4 = is4x4;
        this.numberOfSeats = numberOfSeats;

    }
}
