package com.example.polika.daoDatabases;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.example.polika.daos.SceneContentDao;

public abstract class SceneContentDaoDatabase extends RoomDatabase {
    private static final String DB_NAME = "scene_content_db";
    private static SceneContentDaoDatabase instance;

    public static synchronized SceneContentDaoDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(
                    context.getApplicationContext(),
                    SceneContentDaoDatabase.class, DB_NAME
            ).fallbackToDestructiveMigration().build();
        }
        return instance;
    }

    public abstract SceneContentDao sceneContentDao();
}
