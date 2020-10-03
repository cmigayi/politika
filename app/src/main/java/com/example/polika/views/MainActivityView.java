package com.example.polika.views;

import com.example.polika.data.Player;

import java.util.List;

public interface MainActivityView {
    public void loadedPlayers(List<Player> playerList);
    public void createPlayer();
    public void createdPlayer(Player player);
    public void displayError(String message);
}
