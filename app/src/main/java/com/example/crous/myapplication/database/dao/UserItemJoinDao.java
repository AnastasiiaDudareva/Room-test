package com.example.crous.myapplication.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Transaction;
import android.util.Log;

import com.example.crous.myapplication.database.models.CarItem;
import com.example.crous.myapplication.database.models.CompanyItem;
import com.example.crous.myapplication.database.models.User;
import com.example.crous.myapplication.database.models.UserItemJoin;
import com.example.crous.myapplication.entities.UserItem;

/**
 * Created by crous on 04.01.18.
 */

@Dao
public abstract class UserItemJoinDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insert(UserItemJoin userItemJoin);

    @Query("SELECT * FROM User " +
            "INNER JOIN UserItemJoin ON User.userId = UserItemJoin.userId " +
            "WHERE UserItemJoin.userId IS :userId LIMIT 1")
    public abstract User getUserForUserItem(final String userId);

    @Query("SELECT * FROM CompanyItem " +
            "INNER JOIN UserItemJoin ON CompanyItem.companyId = UserItemJoin.companyId " +
            "WHERE UserItemJoin.userId IS :userId LIMIT 1")
    public abstract CompanyItem getCompanyForUser(final String userId);

    @Query("SELECT * FROM CarItem" +
            " INNER JOIN UserItemJoin ON CarItem.carId = UserItemJoin.carId" +
            " WHERE UserItemJoin.userId IS :userId LIMIT 1")
    public abstract CarItem getCarForUser(final String userId);


    @Transaction
    public UserItem getUserItem(String userId) {
        UserItem userItem = new UserItem();
        userItem.user = getUserForUserItem(userId);
        userItem.setCar(getCarForUser(userId));
        userItem.setCompany(getCompanyForUser(userId));
        return userItem;
    }
}
