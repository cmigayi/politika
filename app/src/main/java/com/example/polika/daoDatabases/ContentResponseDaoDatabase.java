package com.example.polika.daoDatabases;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.polika.daos.ContentResponseDao;
import com.example.polika.data.ContentResponse;

@Database(entities = ContentResponse.class, exportSchema = false, version = 1)
public abstract class ContentResponseDaoDatabase extends RoomDatabase {
    private static final String DB_NAME = "content_response_db";
    private static ContentResponseDaoDatabase instance;

    public static synchronized ContentResponseDaoDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(
                    context.getApplicationContext(),
                    ContentResponseDaoDatabase.class, DB_NAME
            ).fallbackToDestructiveMigration().build();
        }
        return instance;
    }

    public abstract ContentResponseDao contentResponseDao();
}
