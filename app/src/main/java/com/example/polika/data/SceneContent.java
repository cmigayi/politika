package com.example.polika.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "scene_contents")
public class SceneContent {
    @PrimaryKey(autoGenerate = true)
    int id;

    @ColumnInfo(name = "scene_id")
    int sceneId;

    @ColumnInfo(name = "content_type")
    int contentType;

    @ColumnInfo(name = "content")
    String content;

    @ColumnInfo(name = "content_rank")
    int contentRank;

    @ColumnInfo(name = "date_time")
    String dateTime;

    public SceneContent(int id, int sceneId, int contentType, String content, int contentRank, String dateTime) {
        this.id = id;
        this.sceneId = sceneId;
        this.contentType = contentType;
        this.content = content;
        this.contentRank = contentRank;
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

    public int getSceneId() {
        return sceneId;
    }

    public void setSceneId(int sceneId) {
        this.sceneId = sceneId;
    }

    public int getContentType() {
        return contentType;
    }

    public void setContentType(int contentType) {
        this.contentType = contentType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getContentRank() {
        return contentRank;
    }

    public void setContentRank(int contentRank) {
        this.contentRank = contentRank;
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
                ", sceneId=" + sceneId +
                ", contentType=" + contentType +
                ", content=" + content +
                ", contentRank=" + contentRank +
                ", dateTime='" + dateTime + '\'' +
                '}';
    }
}
