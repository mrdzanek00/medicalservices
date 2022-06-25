package com.mas.medicalservices.doUsuniecia.wieloaspektowe;

public class SlowCar extends Car{

    private Double fuelUsage;


    public SlowCar(String name, Integer vintage, String mark, Double fuelUsage) {
        super(name, vintage, mark);
        this.fuelUsage = fuelUsage;
    }

}
