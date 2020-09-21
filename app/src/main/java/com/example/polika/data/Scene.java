package com.example.polika.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "scenes")
public class Scene {
    @PrimaryKey(autoGenerate = true)
    int id;

    @ColumnInfo(name = "scene_content_id")
    int sceneContentId;

    @ColumnInfo(name = "scene_order")
    int sceneOrder;

    @ColumnInfo(name = "date_time")
    String dateTime;

    public Scene(int id, int sceneContentId, int sceneOrder, String dateTime) {
        this.id = id;
        this.sceneContentId = sceneContentId;
        this.sceneOrder = sceneOrder;
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

    public int getSceneContentId() {
        return sceneContentId;
    }

    public void setSceneContentId(int sceneContentId) {
        this.sceneContentId = sceneContentId;
    }

    public int getSceneOrder() {
        return sceneOrder;
    }

    public void setSceneOrder(int sceneOrder) {
        this.sceneOrder = sceneOrder;
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
                ", sceneContentId=" + sceneContentId +
                ", sceneOrder=" + sceneOrder +
                ", dateTime='" + dateTime + '\'' +
                '}';
    }
}
