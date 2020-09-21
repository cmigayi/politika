package com.example.polika.repositories;

import com.example.polika.data.Player;

import java.util.List;

public interface PlayerRepository {
    public interface OnFinishedListener{
        void onFinished(List<Player> playerList);
        void onFailuire(Object response);
    }

    public void createPlayer(Player player, OnFinishedListener onFinishedListener);
    public void getPlayers(OnFinishedListener onFinishedListener);
    public void getPlayer(int playerId, OnFinishedListener onFinishedListener);
}
