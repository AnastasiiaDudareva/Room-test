package com.example.crous.myapplication.database.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.support.annotation.NonNull;

/**
 * Created by crous on 04.01.18.
 */
@Entity(primaryKeys = {"userId"},
        foreignKeys = {
                @ForeignKey(entity = User.class,
                        parentColumns = "userId",
                        childColumns = "userId"),
                @ForeignKey(entity = CarItem.class,
                        parentColumns = "carId",
                        childColumns = "carId"),
                @ForeignKey(entity = CompanyItem.class,
                        parentColumns = "companyId",
                        childColumns = "companyId")
        })
public class UserItemJoin {
    @NonNull
    public String userId;

    public String carId;

    public String companyId;

}
