package com.example.polika.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "response_consequences")
public class ResponseConsequence {
    @PrimaryKey(autoGenerate = true)
    int id;

    @ColumnInfo(name = "health_consequence")
    int healthConsequence;

    @ColumnInfo(name = "popularity_consequence")
    int popularityConsequence;

    @ColumnInfo(name = "family_consequence")
    int familyConsequence;

    @ColumnInfo(name = "date_time")
    String dateTime;

    public ResponseConsequence(int id, int healthConsequence, int popularityConsequence,
                               int familyConsequence, String dateTime) {
        this.id = id;
        this.healthConsequence = healthConsequence;
        this.popularityConsequence = popularityConsequence;
        this.familyConsequence = familyConsequence;
        this.dateTime = dateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHealthConsequence() {
        return healthConsequence;
    }

    public void setHealthConsequence(int healthConsequence) {
        this.healthConsequence = healthConsequence;
    }

    public int getPopularityConsequence() {
        return popularityConsequence;
    }

    public void setPopularityConsequence(int popularityConsequence) {
        this.popularityConsequence = popularityConsequence;
    }

    public int getFamilyConsequence() {
        return familyConsequence;
    }

    public void setFamilyConsequence(int familyConsequence) {
        this.familyConsequence = familyConsequence;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "ResponseConsequence{" +
                "id=" + id +
                ", healthConsequence=" + healthConsequence +
                ", popularityConsequence=" + popularityConsequence +
                ", familyConsequence=" + familyConsequence +
                ", dateTime='" + dateTime + '\'' +
                '}';
    }
}
