package com.mas.medicalservices.doUsuniecia.wieloaspektowe;

public class HistoricCar extends Car {

    private Boolean isWorking;


    public HistoricCar(String name, Integer vintage, String mark, Boolean isWorking) {
        super(name, vintage, mark);
        this.isWorking = isWorking;
    }


}
