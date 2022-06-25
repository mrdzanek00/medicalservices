package com.mas.medicalservices.doUsuniecia.dynamic;

import java.util.Date;

public class WorkingCar extends Car {

    private Date insuranceDate;

    public WorkingCar(String name, Integer vintage, String mark, Date insuranceDate) {
        super(name, vintage, mark);
        this.insuranceDate = insuranceDate;
    }

    public WorkingCar(Car car, Date insuranceDate) {
        super(car.getName(), car.getVintage(), car.getMark());
        this.insuranceDate = insuranceDate;
    }

    public Date getInsuranceDate() {
        return insuranceDate;
    }

    public void setInsuranceDate(Date insuranceDate) {
        this.insuranceDate = insuranceDate;
    }
}
