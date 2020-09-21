package com.example.polika.presenters;

import com.example.polika.data.Player;
import com.example.polika.repositories.PlayerRepository;
import com.example.polika.views.MainActivityView;

import java.util.List;

public class MainActivityPresenter {
    PlayerRepository repository;
    MainActivityView view;

    public MainActivityPresenter(PlayerRepository repository, MainActivityView view) {
        this.repository = repository;
        this.view = view;
    }

    public void loadPlayers(){
        repository.getPlayers(new PlayerRepository.OnFinishedListener() {
            @Override
            public void onFinished(List<Player> playerList) {
                view.loadPlayers(playerList);
            }

            @Override
            public void onFailuire(Object response) {
                view.displayError("Error");
            }
        });
    }
}
