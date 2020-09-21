package com.example.polika.daos;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.polika.data.Player;

import java.util.List;

@Dao
public interface PlayerDao {
    @Query("SELECT * FROM players ORDER BY id DESC")
    public List<Player> getPlayers();

    @Insert
    public Long insertPlayer(Player player);

    @Query("SELECT * FROM players ORDER BY id DESC LIMIT 1")
    public List<Player> getLastInsertedPlayer();

    @Query("SELECT * FROM players WHERE id = :playerId")
    public List<Player> getPlayer(int playerId);
}
