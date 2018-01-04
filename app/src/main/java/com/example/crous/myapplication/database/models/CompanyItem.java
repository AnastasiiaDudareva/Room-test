package com.example.crous.myapplication.database.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class CompanyItem {
    @NonNull
    @PrimaryKey
    public String companyId;
    public String name;
    public String address;
    public String phone;

    public CompanyItem createTest() {
        this.companyId = "1";
        this.name = "Company";
        this.address = "Company address";
        this.phone = "0000000000";
        return this;
    }

    @Override
    public String toString() {
        return "CompanyItem{" +
                "companyId='" + companyId + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
