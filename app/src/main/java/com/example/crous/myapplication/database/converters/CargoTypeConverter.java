package com.example.crous.myapplication.database.converters;

import android.arch.persistence.room.TypeConverter;

import com.example.crous.myapplication.entities.CargoType;
import com.google.gson.Gson;

/**
 * Created by crous on 04.01.18.
 */
public class CargoTypeConverter {
    @TypeConverter
    public static CargoType fromString(String value) {
        return new Gson().fromJson(value, CargoType.class);
    }

    @TypeConverter
    public static String fromCargoType(CargoType cargoType) {
        Gson gson = new Gson();
        String json = gson.toJson(cargoType);
        return json;
    }
}
