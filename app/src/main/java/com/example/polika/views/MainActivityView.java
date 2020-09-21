package com.example.polika.views;

import com.example.polika.data.Player;

import java.util.List;

public interface MainActivityView {
    public void loadPlayers(List<Player> playerList);
    public void displayError(String message);
}
