package com.example.crous.myapplication.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.crous.myapplication.database.models.User;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(User userItem);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(User... userItems);

    @Delete
    int delete(User userItem);

    @Query("SELECT * FROM User")
    List<User> getAllItems();

    @Query("SELECT * FROM User WHERE userId IS :userId LIMIT 1")
    User getItemById(String userId);
}
