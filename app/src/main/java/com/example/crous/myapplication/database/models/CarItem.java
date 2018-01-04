package com.example.crous.myapplication.database.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;


/**
 * Created by crous on 04.01.18.
 */
@Entity
public class CarItem {
    @NonNull
    @PrimaryKey
    public String carId;
    public String model;
    public String name;
    public String number;
    public boolean is_express;
    public String licence;
    public String licanceImgUrl;
    public String capacity;
    public String tonnage;


    public CarItem createTest() {
        carId = "1";
        model = "model";
        name = "name";
        number = "num0000ber";
        is_express = false;
        licence = "licence";
        licanceImgUrl = "licanceImgUrl";
        capacity = "capacity";
        tonnage = "tonnage";
        return this;
    }

    @Override
    public String toString() {
        return "CarItem{" +
                "carId='" + carId + '\'' +
                ", model='" + model + '\'' +
                ", name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", is_express=" + is_express +
                ", licence='" + licence + '\'' +
                ", licanceImgUrl='" + licanceImgUrl + '\'' +
                ", capacity='" + capacity + '\'' +
                ", tonnage='" + tonnage + '\'' +
                '}';
    }
}
