package com.example.polika.daoDatabases;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.example.polika.daos.SceneDao;
import com.example.polika.data.Scene;

@Database(entities = Scene.class, exportSchema = false, version = 1)
public abstract class SceneDaoDatabase extends RoomDatabase {
    private static final String DB_NAME = "scene_db";
    private static SceneDaoDatabase instance;

    public static synchronized SceneDaoDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(
                    context.getApplicationContext(),
                    SceneDaoDatabase.class, DB_NAME
            ).fallbackToDestructiveMigration().build();
        }
        return instance;
    }

    public abstract SceneDao sceneDao();
}
