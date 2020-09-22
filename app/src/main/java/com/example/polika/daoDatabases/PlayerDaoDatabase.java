package com.example.polika.daoDatabases;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.example.polika.daos.PlayerDao;
import com.example.polika.data.Player;

@Database(entities = Player.class, exportSchema = false, version = 1)
public abstract class PlayerDaoDatabase extends RoomDatabase {
    private static final String DB_NAME = "player_db";
    private static PlayerDaoDatabase instance;

    public static synchronized PlayerDaoDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(
                    context.getApplicationContext(),
                    PlayerDaoDatabase.class, DB_NAME
            ).fallbackToDestructiveMigration().build();
        }
        return instance;
    }

    public abstract PlayerDao playerDao();
}
