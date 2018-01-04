package com.example.crous.myapplication.database;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.example.crous.myapplication.database.models.CargoItemJoin;
import com.example.crous.myapplication.database.models.UserItemJoin;
import com.example.crous.myapplication.entities.CargoItem;
import com.example.crous.myapplication.entities.UserItem;

import io.reactivex.Completable;
import io.reactivex.Single;

/**
 * Created by crous on 04.01.18.
 */

public class DBHelper {

    private static final String DB_NAME = "database.db";
    private static volatile AppDatabase db;

    public static void init(Context context) {
        db = Room.databaseBuilder(context,
                AppDatabase.class,
                DB_NAME).build();
    }

    public static Completable insertUser(UserItem test) {
        return Completable.create(e -> {
            db.getUserDao().insert(test.user);
            UserItemJoin join = new UserItemJoin();
            join.userId = test.user.userId;
            if (test.getCar() != null) {
                db.getCarDao().insert(test.getCar());
                join.carId = test.getCar().carId;
            }
            if (test.getClass() != null) {
                db.getCompanyDao().insert(test.getCompany());
                join.companyId = test.getCompany().companyId;
            }
            db.getUserItemJoinDao().insert(join);
            e.onComplete();
        });
    }

    public static Single<UserItem> getUserById(String id) {
        return Single.create(e -> {
            UserItem userItem = db.getUserItemJoinDao().getUserItem(id);
            if (userItem != null) {
                e.onSuccess(userItem);
            } else {
                e.onError(new Throwable("User with id " + id + " not found in database"));
            }
        });
    }


}
