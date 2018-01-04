package com.example.crous.myapplication.database.converters;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;

import java.util.Date;

/**
 * Created by crous on 04.01.18.
 */

public class DateConverter {
    @TypeConverter
    public static Date fromString(String value) {
        return new Gson().fromJson(value, Date.class);
    }

    @TypeConverter
    public static String fromLocation(Date location) {
        Gson gson = new Gson();
        String json = gson.toJson(location);
        return json;
    }
}
