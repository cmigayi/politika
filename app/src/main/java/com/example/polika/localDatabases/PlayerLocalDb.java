package com.example.polika.localDatabases;

import android.content.Context;
import android.util.Log;

import com.example.polika.commons.AppExecutors;
import com.example.polika.daoDatabases.PlayerDaoDatabase;
import com.example.polika.data.Player;
import com.example.polika.repositories.PlayerRepository;

import java.util.List;

public class PlayerLocalDb implements PlayerRepository {
    final String mPlayerLocalDb = "PlayerLocalDb";
    PlayerDaoDatabase playerDaoDatabase;

    public PlayerLocalDb(Context context) {
        playerDaoDatabase = PlayerDaoDatabase.getInstance(context);
    }

    @Override
    public void createPlayer(final Player player, final OnFinishedListener onFinishedListener) {
        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Long status = playerDaoDatabase.playerDao().insertPlayer(player);
                    if (status > 0) {
                        List<Player> playerList = playerDaoDatabase.playerDao().getLastInsertedPlayer();
                        onFinishedListener.onFinished(playerList);
                        Log.d(mPlayerLocalDb, "Success01: " + playerList.get(0).getId());
                    }
                }catch (Exception e){
                    onFinishedListener.onFailuire(e);
                }
            }
        });
    }

    @Override
    public void getPlayers(final OnFinishedListener onFinishedListener) {
        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                try {
                    List<Player> playerList = playerDaoDatabase.playerDao().getPlayers();
                    onFinishedListener.onFinished(playerList);
                }catch (Exception e){
                    onFinishedListener.onFailuire(e);
                }
            }
        });
    }

    @Override
    public void getPlayer(int playerId, OnFinishedListener onFinishedListener) {
        try {
            List<Player> playerList = playerDaoDatabase.playerDao().getPlayer(playerId);
            onFinishedListener.onFinished(playerList);
        }catch (Exception e){
            onFinishedListener.onFailuire(e);
        }
    }
}
