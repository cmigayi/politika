package com.example.polika.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "scene_contents")
public class SceneContent {
    @PrimaryKey(autoGenerate = true)
    int id;

    @ColumnInfo(name = "subcontent_id")
    int subcontentId;

    @ColumnInfo(name = "content_order")
    int contentOrder;

    @ColumnInfo(name = "date_time")
    String dateTime;

    public SceneContent(int id, int subcontentId, int contentOrder, String dateTime) {
        this.id = id;
        this.subcontentId = subcontentId;
        this.contentOrder = contentOrder;
        this.dateTime = dateTime;
    }

    @Ignore
    public SceneContent() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSubcontentId() {
        return subcontentId;
    }

    public void setSubcontentId(int subcontentId) {
        this.subcontentId = subcontentId;
    }

    public int getContentOrder() {
        return contentOrder;
    }

    public void setContentOrder(int contentOrder) {
        this.contentOrder = contentOrder;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "SceneContent{" +
                "id=" + id +
                ", subcontentId=" + subcontentId +
                ", contentOrder=" + contentOrder +
                ", dateTime='" + dateTime + '\'' +
                '}';
    }
}
