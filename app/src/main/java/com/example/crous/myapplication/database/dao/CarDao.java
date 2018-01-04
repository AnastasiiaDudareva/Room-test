package com.example.crous.myapplication.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.crous.myapplication.database.models.CarItem;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface CarDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(CarItem carItem);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(CarItem... carItems);

    @Delete
    int delete(CarItem carItem);

    @Query("SELECT * FROM CarItem")
    List<CarItem> getAllItems();

    @Query("SELECT * FROM CarItem WHERE carId IS :carId LIMIT 1")
    CarItem getItemById(String carId);
}
