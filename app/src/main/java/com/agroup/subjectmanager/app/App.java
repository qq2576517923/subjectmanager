package com.agroup.subjectmanager.app;

import android.app.Application;

import com.agroup.subjectmanager.database.table.AppDatabase;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AppDatabase.init( this);
    }
}