package com.example.polika.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "profiles")
public class Profile {
    @PrimaryKey(autoGenerate = true)
    int id;

    @ColumnInfo(name = "player_id")
    int playerId;

    @ColumnInfo(name = "health")
    int health;

    @ColumnInfo(name = "popularity")
    int popularity;

    @ColumnInfo(name = "family")
    int family;

    @ColumnInfo(name = "date_time")
    String dateTime;

    public Profile(int id, int playerId, int health, int popularity, int family, String dateTime) {
        this.id = id;
        this.playerId = playerId;
        this.health = health;
        this.popularity = popularity;
        this.family = family;
        this.dateTime = dateTime;
    }

    @Ignore
    public Profile() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public int getFamily() {
        return family;
    }

    public void setFamily(int family) {
        this.family = family;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "id=" + id +
                ", playerId=" + playerId +
                ", health=" + health +
                ", popularity=" + popularity +
                ", family=" + family +
                ", dateTime='" + dateTime + '\'' +
                '}';
    }
}
