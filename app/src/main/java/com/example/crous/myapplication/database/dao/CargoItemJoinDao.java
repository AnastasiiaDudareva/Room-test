package com.example.crous.myapplication.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Transaction;

import com.example.crous.myapplication.database.models.CarItem;
import com.example.crous.myapplication.database.models.Cargo;
import com.example.crous.myapplication.database.models.CargoItemJoin;
import com.example.crous.myapplication.database.models.User;
import com.example.crous.myapplication.entities.CargoItem;

/**
 * Created by crous on 04.01.18.
 */

@Dao
public abstract class CargoItemJoinDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insert(CargoItemJoin cargoItemJoin);

    @Query("SELECT * FROM User" +
            " INNER JOIN CargoItemJoin ON User.userId = CargoItemJoin.senderId" +
            " WHERE CargoItemJoin.cargoId IS :cargoId" +
            " LIMIT 1")
    public abstract User getSenderForCargo(final String cargoId);

    @Query("SELECT * FROM User" +
            " INNER JOIN CargoItemJoin ON User.userId = CargoItemJoin.recipientId" +
            " WHERE CargoItemJoin.cargoId IS :cargoId" +
            " LIMIT 1")
    public abstract User getRecipientForCargo(final String cargoId);

    @Query("SELECT * FROM CarItem" +
            " INNER JOIN CargoItemJoin ON CarItem.carId = CargoItemJoin.carId" +
            " WHERE CargoItemJoin.cargoId IS :cargoId" +
            " LIMIT 1")
    public abstract CarItem getCarForCargo(final String cargoId);

    @Query("SELECT * FROM Cargo" +
            " INNER JOIN CargoItemJoin ON Cargo.cargoId = CargoItemJoin.cargoId" +
            " WHERE CargoItemJoin.cargoId IS :cargoId" +
            " LIMIT 1")
    public abstract Cargo getCargoForCargo(final String cargoId);

    @Transaction
    public CargoItem getCargoItem(String id) {
        CargoItem cargoItem = new CargoItem();
        cargoItem.setCargo(getCargoForCargo(id));
        cargoItem.setCar(getCarForCargo(id));
        cargoItem.setRecipient(getRecipientForCargo(id));
        cargoItem.setSender(getSenderForCargo(id));
        return cargoItem;
    }
}
