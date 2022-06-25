package com.mas.medicalservices.doUsuniecia.wielodziedziczenie;

public class SportSuv extends Suv implements ISportCar {

    SportCar sportCar;

    public SportSuv(String name, Integer vintage, String mark, Boolean is4x4, Integer numberOfSeats, Integer horsePower, Double engineCapacity) {
        super(name, vintage, mark, is4x4, numberOfSeats);
        sportCar = new SportCar(null,null,null,horsePower,engineCapacity); // bez powtorzen danych daje nulle
    }


    @Override
    public Integer getHorsePower() {
       return this.sportCar.getHorsePower();
    }

    @Override
    public Double getEngineCapacity() {
        return this.sportCar.getEngineCapacity();
    }
}
