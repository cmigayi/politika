package com.example.polika.daoDatabases;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.polika.daos.ResponseConsequenceDao;
import com.example.polika.data.ResponseConsequence;

@Database(entities = ResponseConsequence.class, exportSchema = false, version = 1)
public abstract class ResponseConsequenceDaoDatabase extends RoomDatabase {
    private static final String DB_NAME = "response_consequence_db";
    private static ResponseConsequenceDaoDatabase instance;

    public static synchronized ResponseConsequenceDaoDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(
                    context.getApplicationContext(),
                    ResponseConsequenceDaoDatabase.class, DB_NAME
            ).fallbackToDestructiveMigration().build();
        }
        return instance;
    }

    public abstract ResponseConsequenceDao responseConsequenceDao();
}
