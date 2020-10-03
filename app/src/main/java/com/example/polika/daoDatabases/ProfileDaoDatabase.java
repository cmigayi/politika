package com.example.polika.daoDatabases;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.polika.daos.PlayerDao;
import com.example.polika.daos.ProfileDao;
import com.example.polika.data.Player;
import com.example.polika.data.Profile;

@Database(entities = Profile.class, exportSchema = false, version = 1)
public abstract class ProfileDaoDatabase extends RoomDatabase {
    private static final String DB_NAME = "profile_db";
    private static ProfileDaoDatabase instance;

    public static synchronized ProfileDaoDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(
                    context.getApplicationContext(),
                    ProfileDaoDatabase.class, DB_NAME
            ).fallbackToDestructiveMigration().build();
        }
        return instance;
    }

    public abstract ProfileDao profileDao();
}
