package com.example.polika.presenters;

import android.util.Log;

import com.example.polika.commons.AppExecutors;
import com.example.polika.data.Player;
import com.example.polika.repositories.PlayerRepository;
import com.example.polika.views.MainActivityView;

import java.util.List;

public class MainActivityPresenter {
    final static String mMainActivityPresenter = "MainActivityPresenter";
    PlayerRepository repository;
    MainActivityView view;

    public MainActivityPresenter(PlayerRepository repository, MainActivityView view) {
        this.repository = repository;
        this.view = view;
    }

    public void createPlayer(Player player){
        repository.createPlayer(player, new PlayerRepository.OnFinishedListener() {
            @Override
            public void onFinished(final List<Player> playerList) {
                AppExecutors.getInstance().mainThread().execute(new Runnable() {
                    @Override
                    public void run() {
                        Log.d(mMainActivityPresenter, "response: "+playerList);
                        view.createdPlayer(playerList.get(0));
                    }
                });
            }

            @Override
            public void onFailuire(Throwable t) {
                Log.d(mMainActivityPresenter, "Error: "+t.getMessage());
                view.displayError("There was an error: "+t.getMessage());
            }
        });
    }

    public void loadPlayers(){
        repository.getPlayers(new PlayerRepository.OnFinishedListener() {
            @Override
            public void onFinished(final List<Player> playerList) {
                AppExecutors.getInstance().mainThread().execute(new Runnable() {
                    @Override
                    public void run() {
                        view.loadedPlayers(playerList);
                    }
                });
            }

            @Override
            public void onFailuire(Throwable t) {
                view.displayError("Error");
            }
        });
    }
}
