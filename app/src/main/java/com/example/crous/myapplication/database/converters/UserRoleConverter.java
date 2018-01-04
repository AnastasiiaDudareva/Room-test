package com.example.crous.myapplication.database.converters;

import android.arch.persistence.room.TypeConverter;

import com.example.crous.myapplication.entities.UserRole;
import com.google.gson.Gson;

public class UserRoleConverter {
    @TypeConverter
    public static UserRole fromString(String value) {
        return new Gson().fromJson(value, UserRole.class);
    }

    @TypeConverter
    public static String fromUserRole(UserRole role) {
        Gson gson = new Gson();
        String json = gson.toJson(role);
        return json;
    }
}
