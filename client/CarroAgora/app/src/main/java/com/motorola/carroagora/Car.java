package com.motorola.carroagora;

import android.text.TextUtils;

public class Car {
    private String brand;
    private String model;
    private int year;
    private Fuel fuel;
    private int optionals;
    private float price;
    private String plate;

    private Person owner;

    private String availableDate;
    private int startTime;
    private int endTime;

    public static final int OPTIONAL_AIR_CONDITIONER = 1;
    public static final int OPTIONAL_DIRECAO_HIDRAULICA = 2;
    public static final int OPTIONAL_TRIO_ELETRICO = 4;

    public enum Fuel {
        GASOLINE,
        ALCOHOL,
        FLEX,
    }

    public static int stringToInt(String value) {
        if (TextUtils.isEmpty(value)) {
            return 0;
        }
        return Integer.valueOf(value);
    }

    public static float stringToFloat(String value) {
        if (TextUtils.isEmpty(value)) {
            return 0;
        }
        return Float.valueOf(value);
    }
    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Fuel getFuel() {
        return fuel;
    }

    public void setFuel(Fuel fuel) {
        this.fuel = fuel;
    }

    public int getOptionals() {
        return optionals;
    }

    public void setOptionals(int optionals) {
        this.optionals = optionals;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public String getAvailableDate() {
        return availableDate;
    }

    public void setAvailableDate(String availableDate) {
        this.availableDate = availableDate;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

}