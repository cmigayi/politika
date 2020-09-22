package com.example.polika.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "content_responses")
public class ContentResponse {
    @PrimaryKey(autoGenerate = true)
    int id;

    @ColumnInfo(name = "content_id")
    int contentId;

    @ColumnInfo(name = "response")
    String response;

    @ColumnInfo(name = "response_leads_to")
    int responseLeadsTo;

    @ColumnInfo(name = "date_time")
    String dateTime;

    public ContentResponse(int id, int contentId, String response, int responseLeadsTo, String dateTime) {
        this.id = id;
        this.contentId = contentId;
        this.response = response;
        this.responseLeadsTo = responseLeadsTo;
        this.dateTime = dateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getContentId() {
        return contentId;
    }

    public void setContentId(int contentId) {
        this.contentId = contentId;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public int getResponseLeadsTo() {
        return responseLeadsTo;
    }

    public void setResponseLeadsTo(int responseLeadsTo) {
        this.responseLeadsTo = responseLeadsTo;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "ContentResponse{" +
                "id=" + id +
                ", contentId=" + contentId +
                ", response='" + response + '\'' +
                ", responseLeadsTo=" + responseLeadsTo +
                ", dateTime='" + dateTime + '\'' +
                '}';
    }
}
