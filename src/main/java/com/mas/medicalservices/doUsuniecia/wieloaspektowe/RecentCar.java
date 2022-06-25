package com.mas.medicalservices.doUsuniecia.wieloaspektowe;

public class RecentCar extends Car{

    private String engineType;

    private Double marketPrice;

    public RecentCar(String name, Integer vintage, String mark, String engineType, Double marketPrice) {
        super(name, vintage, mark);
        this.engineType = engineType;
        this.marketPrice = marketPrice;
    }


}
