package com.mas.medicalservices.doUsuniecia.wielodziedziczenie;


public class SportCar extends Car implements ISportCar {

    private Integer horsePower;

    private Double engineCapacity;

    public SportCar(String name, Integer vintage, String mark,Integer horsePower, Double engineCapacity) {
        super(name,vintage,mark);
        this.horsePower = horsePower;
        this.engineCapacity = engineCapacity;
    }

    @Override
    public Integer getHorsePower() {
        return this.horsePower;
    }

    @Override
    public Double getEngineCapacity() {
        return this.engineCapacity;
    }
}
