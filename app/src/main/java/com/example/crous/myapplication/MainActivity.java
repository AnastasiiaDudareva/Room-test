package com.example.crous.myapplication;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.crous.myapplication.database.AppDatabase;
import com.example.crous.myapplication.database.DBHelper;
import com.example.crous.myapplication.entities.UserItem;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBHelper.init(this);
        DBHelper.insertUser(new UserItem().createTest())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe();

        DBHelper.getUserById("2").subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(userItem -> {
                    Log.e("userItem", userItem.toString());
                });
    }
}
