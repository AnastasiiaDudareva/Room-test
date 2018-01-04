package com.example.crous.myapplication.entities;

import android.arch.persistence.room.TypeConverter;
import android.location.Location;

import java.util.ArrayList;
import java.util.List;

public class TrackingItem {
    String trackingId;
    String model;
    String name;
    String number;
    boolean isExpress;
    Location location;
    List<Location> geopoints = new ArrayList<>();
    List<CargoItem> cargoItems = new ArrayList<>();
}

