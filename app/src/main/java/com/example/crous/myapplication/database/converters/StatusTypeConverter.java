package com.example.crous.myapplication.database.converters;

import android.arch.persistence.room.TypeConverter;

import com.example.crous.myapplication.entities.StatusType;
import com.google.gson.Gson;

public class StatusTypeConverter {
    @TypeConverter
    public static StatusType fromString(String value) {
        return new Gson().fromJson(value, StatusType.class);
    }

    @TypeConverter
    public static String fromCargoType(StatusType statusType) {
        Gson gson = new Gson();
        String json = gson.toJson(statusType);
        return json;
    }
}
