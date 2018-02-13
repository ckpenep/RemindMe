package com.example.ckpenep.remindme;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.Context;

import com.example.ckpenep.remindme.db.DatabaseHelper;

/**
 * Created by ckpenep on 11.02.2018.
 */

public class App extends Application {

    private static App instance;
    private DatabaseHelper db;
    private Context context;

    public static App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        instance = this;
        db = Room.databaseBuilder(getApplicationContext(), DatabaseHelper.class, "data-database")
                .allowMainThreadQueries() //разрешает нам делать запросы сразу в UI потоке без лишних обработчиков
                .build();
    }

    public DatabaseHelper getDatabaseInstance() {
        return db;
    }

    public Context getContext() {
        return context;
    }
}
