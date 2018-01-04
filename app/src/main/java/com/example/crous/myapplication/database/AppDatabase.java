package com.example.crous.myapplication.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import com.example.crous.myapplication.database.converters.CargoTypeConverter;
import com.example.crous.myapplication.database.converters.DateConverter;
import com.example.crous.myapplication.database.converters.LocationConverter;
import com.example.crous.myapplication.database.converters.StatusTypeConverter;
import com.example.crous.myapplication.database.converters.UserRoleConverter;
import com.example.crous.myapplication.database.dao.CarDao;
import com.example.crous.myapplication.database.dao.CargoDao;
import com.example.crous.myapplication.database.dao.CargoItemJoinDao;
import com.example.crous.myapplication.database.dao.CompanyDao;
import com.example.crous.myapplication.database.dao.UserDao;
import com.example.crous.myapplication.database.dao.UserItemJoinDao;
import com.example.crous.myapplication.database.models.CarItem;
import com.example.crous.myapplication.database.models.Cargo;
import com.example.crous.myapplication.database.models.CargoItemJoin;
import com.example.crous.myapplication.database.models.CompanyItem;
import com.example.crous.myapplication.database.models.User;
import com.example.crous.myapplication.database.models.UserItemJoin;

@Database(entities = {
        CargoItemJoin.class,
        UserItemJoin.class,
        CarItem.class,
        CompanyItem.class,
        User.class,
        Cargo.class}, version = 1)
@TypeConverters({UserRoleConverter.class,
        LocationConverter.class,
        CargoTypeConverter.class,
        StatusTypeConverter.class,
        DateConverter.class})
public abstract class AppDatabase extends RoomDatabase {

    public abstract CarDao getCarDao();

    public abstract UserDao getUserDao();

    public abstract CompanyDao getCompanyDao();

    public abstract CargoDao getCargoDao();

    public abstract CargoItemJoinDao getCargoItemJoinDao();

    public abstract UserItemJoinDao getUserItemJoinDao();

}
