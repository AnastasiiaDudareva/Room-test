package com.example.crous.myapplication.database.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.location.Location;
import android.support.annotation.NonNull;

import com.example.crous.myapplication.entities.CargoType;
import com.example.crous.myapplication.entities.StatusType;

import java.util.Date;

/**
 * Created by crous on 04.01.18.
 */
@Entity
public class Cargo {
    @NonNull
    @PrimaryKey
    public String cargoId;
    public String fromAddress;
    public String toAddress;
    public Location fromGeopoint;
    public Location toGeopoint;
    public CargoType type;
    public float weight;
    public String size;
    public String name;
    public StatusType status;
    public Date pickupDate;
    public Date dropDate;


    public Cargo createTest() {
        this.fromAddress = "Address, 1";
        this.toAddress = "Address, 2";
        this.fromGeopoint = new Location("");
        this.fromGeopoint.setLatitude(35.442);
        this.fromGeopoint.setLongitude(47.532);
        this.toGeopoint = new Location("");
        this.toGeopoint.setLatitude(35.445);
        this.toGeopoint.setLongitude(47.535);
        this.type = CargoType.EXPRESS;
        this.weight = 1.0f;
        this.size = "1";
        this.name = "new Cargo";
        this.status = StatusType.NEW;
        this.pickupDate = new Date();
        this.dropDate = new Date();
        return this;
    }
}
