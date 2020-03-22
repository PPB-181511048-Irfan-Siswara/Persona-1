package com.example.taskmanager;

import android.app.Application;

import androidx.room.Room;

public class MyApp extends Application {

    public static TaskDatabase db;

    @Override
    public void onCreate() {
        super.onCreate();
        db = Room.databaseBuilder(getApplicationContext(),
                TaskDatabase.class,"Task").allowMainThreadQueries().build();
    }

}
