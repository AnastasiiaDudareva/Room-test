package com.example.crous.myapplication.database.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.example.crous.myapplication.entities.UserRole;


/**
 * Created by crous on 04.01.18.
 */
@Entity
public class User {
    @NonNull
    @PrimaryKey
    public String userId;
    public String email;
    public String phone;
    public UserRole role;
    public String name;
    public String surname;
    public String icon;
    public String address;

    public User() {
        this.userId = "1";
    }

    public User createTest() {
        this.email = "test@test.com";
        this.phone = "80987654321";
        this.role = UserRole.CLIENT;
        this.name = "Name";
        this.surname = "Surname";
        this.icon = "icon";
        this.address = "address, 1";
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", role=" + role +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", icon='" + icon + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
