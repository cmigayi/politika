package com.example.polika.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "scenes")
public class Scene {
    @PrimaryKey(autoGenerate = true)
    int id;

    @ColumnInfo(name = "name")
    String name;

    @ColumnInfo(name = "scene_rank")
    int sceneRank;

    @ColumnInfo(name = "date_time")
    String dateTime;

    public Scene(int id, String name, int sceneRank, String dateTime) {
        this.id = id;
        this.name = name;
        this.sceneRank = sceneRank;
        this.dateTime = dateTime;
    }

    @Ignore
    public Scene() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSceneRank() {
        return sceneRank;
    }

    public void setSceneRank(int sceneRank) {
        this.sceneRank = sceneRank;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Scene{" +
                "id=" + id +
                ", name =" + name +
                ", sceneRank=" + sceneRank +
                ", dateTime='" + dateTime + '\'' +
                '}';
    }
}
