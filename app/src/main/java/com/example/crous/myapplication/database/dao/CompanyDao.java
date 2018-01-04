package com.example.crous.myapplication.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.crous.myapplication.database.models.CompanyItem;

import java.util.List;

@Dao
public interface CompanyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(CompanyItem item);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(CompanyItem... item);

    @Delete
    int delete(CompanyItem item);

    @Query("SELECT * FROM CompanyItem")
    List<CompanyItem> getAllItems();

    @Query("SELECT * FROM CompanyItem WHERE companyId IS :companyId LIMIT 1")
    CompanyItem getItemById(String companyId);
}
