package com.mas.medicalservices.doUsuniecia.dynamic;

public abstract class Car {

    private String name;

    private Integer vintage;

    private String mark;

    public Car(String name, Integer vintage, String mark) {
        this.name = name;
        this.vintage = vintage;
        this.mark = mark;
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
}
