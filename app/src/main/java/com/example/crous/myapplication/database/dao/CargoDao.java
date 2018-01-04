package com.example.crous.myapplication.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.crous.myapplication.database.models.Cargo;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface CargoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Cargo cargo);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(Cargo... cargos);

    @Delete
    int delete(Cargo carItem);

    @Query("SELECT * FROM Cargo")
    List<Cargo> getAllItems();

    @Query("SELECT * FROM Cargo WHERE cargoId IS :cargoId LIMIT 1")
    Cargo getItemById(String cargoId);
}
