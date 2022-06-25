package com.mas.medicalservices.doUsuniecia.dynamic;

import java.util.ArrayList;
import java.util.List;

public class BrokenCar extends Car {

    private List<String> partsToRepair = new ArrayList<>();

    private Boolean isRepairable ;

    public BrokenCar(String name, Integer vintage, String mark, List<String> partsToRepair, Boolean isRepairable) {
        super(name, vintage, mark);
        this.partsToRepair = partsToRepair;
        this.isRepairable = isRepairable;
    }

    public BrokenCar(Car car, List<String> partsToRepair, Boolean isRepairable) {
        super(car.getName(), car.getVintage(), car.getMark());
        this.partsToRepair = partsToRepair;
        this.isRepairable = isRepairable;
    }

    public List<String> getPartsToRepair() {
        return partsToRepair;
    }

    public void setPartsToRepair(List<String> partsToRepair) {
        this.partsToRepair = partsToRepair;
    }

    public Boolean getRepairable() {
        return isRepairable;
    }

    public void setRepairable(Boolean repairable) {
        isRepairable = repairable;
    }
}
