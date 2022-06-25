package com.mas.medicalservices.doUsuniecia.overlapping;

import java.util.EnumSet;

public class Car {

    private String name;

    private Integer vintage;

    private String mark;

    private Integer horsePower;// sport

    private Double engineCapacity;// sport

    private Boolean offRoadCapabilty; // Suv


    private final EnumSet<CarType> carTypes =  EnumSet.of(CarType.Car);

    public Car(String name, Integer vintage, String mark, CarType carType) {
        this.name = name;
        this.vintage = vintage;
        this.mark = mark;

        this.carTypes.add(carType);

    }

    public Car(String name, Integer vintage, String mark, EnumSet<CarType> carType) {
        this.name = name;
        this.vintage = vintage;
        this.mark = mark;

        this.carTypes.addAll(carType);

    }


    public Car(String name, Integer vintage, String mark, Integer horsePower, Double engineCapacity) {
        this.name = name;
        this.vintage = vintage;
        this.mark = mark;
        this.horsePower = horsePower;
        this.engineCapacity = engineCapacity;

        this.carTypes.add(CarType.SportCar);
    }

    public Car(String name, Integer vintage, String mark, Boolean offRoadCapabilty) {
        this.name = name;
        this.vintage = vintage;
        this.mark = mark;
        this.offRoadCapabilty = offRoadCapabilty;

        this.carTypes.add(CarType.Suv);
    }

    public Car(String name, Integer vintage, String mark, Integer horsePower, Double engineCapacity, Boolean offRoadCapabilty) {
        this.name = name;
        this.vintage = vintage;
        this.mark = mark;
        this.horsePower = horsePower;
        this.engineCapacity = engineCapacity;
        this.offRoadCapabilty = offRoadCapabilty;

        this.carTypes.add(CarType.Suv);
        this.carTypes.add(CarType.SportCar);

    }


    public void addCarType(CarType carType){
        if(carType != null){
            this.carTypes.add(carType);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getVintage() {
        return vintage;
    }

    public void setVintage(Integer vintage) {
        this.vintage = vintage;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Integer getHorsePower() throws Exception {
        if(carTypes.contains(CarType.SportCar))
            return horsePower;
        else
            throw new Exception("Not a sport car");
    }

    public void setHorsePower(Integer horsePower) throws Exception {
        if(carTypes.contains(CarType.SportCar))
            this.horsePower = horsePower;
        else
            throw new Exception("Not a sport car");
    }

    public Double getEngineCapacity() throws Exception {
        if(carTypes.contains(CarType.SportCar))
            return engineCapacity;
        else
            throw new Exception("Not a sport car");
    }

    public void setEngineCapacity(Double engineCapacity) throws Exception {
        if(carTypes.contains(CarType.SportCar))
            this.engineCapacity = engineCapacity;
          else
        throw new Exception("Not a sport car");
    }

    public Boolean getOffRoadCapabilty() throws Exception {
        if(carTypes.contains(CarType.Suv))
            return offRoadCapabilty;
        else
            throw new Exception("Not a suv car");
    }

    public void setOffRoadCapabilty(Boolean offRoadCapabilty) throws Exception {
        if(carTypes.contains(CarType.Suv))
            this.offRoadCapabilty = offRoadCapabilty;
        else
            throw new Exception("Not a suv car");
    }
}
