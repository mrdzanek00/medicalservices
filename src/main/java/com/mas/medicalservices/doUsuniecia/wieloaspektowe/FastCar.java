package com.mas.medicalservices.doUsuniecia.wieloaspektowe;

public class FastCar extends Car{

    private Integer vMax;

    private Double timeTo100;


    public FastCar(String name, Integer vintage, String mark, Integer vMax, Double timeTo100) {
        super(name, vintage, mark);
        this.vMax = vMax;
        this.timeTo100 = timeTo100;
    }


}
