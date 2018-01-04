package com.example.crous.myapplication.database.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.support.annotation.NonNull;

/**
 * Created by crous on 04.01.18.
 */
@Entity(primaryKeys = {"cargoId", "senderId", "recipientId", "carId"},
        foreignKeys = {
                @ForeignKey(entity = User.class,
                        parentColumns = "userId",
                        childColumns = "senderId"),
                @ForeignKey(entity = User.class,
                        parentColumns = "userId",
                        childColumns = "recipientId"),
                @ForeignKey(entity = Cargo.class,
                        parentColumns = "cargoId",
                        childColumns = "cargoId"),
                @ForeignKey(entity = CarItem.class,
                        parentColumns = "carId",
                        childColumns = "carId")
        })
public class CargoItemJoin {
    @NonNull
    public final String cargoId;
    @NonNull
    public final String senderId;
    @NonNull
    public final String recipientId;
    @NonNull
    public final String carId;

    public CargoItemJoin(@NonNull String cargoId, @NonNull String senderId, @NonNull String recipientId, @NonNull String carId) {
        this.cargoId = cargoId;
        this.senderId = senderId;
        this.recipientId = recipientId;
        this.carId = carId;
    }
}
