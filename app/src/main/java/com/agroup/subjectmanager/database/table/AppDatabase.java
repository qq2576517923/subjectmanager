package com.agroup.subjectmanager.database.table;

import android.app.Application;

import com.agroup.subjectmanager.database.dao.SubjectDao;
import com.agroup.subjectmanager.database.table.SubjectEntity;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


@Database(entities = {SubjectEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    /**
     * database name
     */
    private static final String DB_NAME = "agroup";

    /**
     * 单例
     */
    private static AppDatabase sInstance;

    /**
     * 在Application中做初始化操作
     *
     * @param application a
     */
    public static void init(Application application) {
        if (sInstance == null) {
            synchronized (AppDatabase.class) {
                if (sInstance == null) {
                    sInstance = Room.databaseBuilder(application, AppDatabase.class, DB_NAME).build();
                }
            }
        }
    }

    /**
     * 获取实例
     *
     * @return 没有初始化抛出异常
     */
    public static AppDatabase getInstance() {
        synchronized (AppDatabase.class) {
            if (sInstance == null) {
                throw new NullPointerException("database == null");
            }
        }
        return sInstance;
    }

    /**
     * 获取SubjectDao的实例
     *
     * @return SubjectDao实例
     */
    public abstract SubjectDao getSubjectDao();

}
