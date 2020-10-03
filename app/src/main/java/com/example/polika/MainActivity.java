package com.example.polika;

import android.content.Intent;
import android.os.Bundle;

import com.example.polika.adapters.CustomPlayerAdapter;
import com.example.polika.data.Player;
import com.example.polika.localDatabases.PlayerLocalDb;
import com.example.polika.localDatabases.SceneLocalDb;
import com.example.polika.localProfiles.PlayerLocalProfile;
import com.example.polika.preload.PopulateScene;
import com.example.polika.presenters.MainActivityPresenter;
import com.example.polika.views.MainActivityView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity
        implements MainActivityView, View.OnClickListener, CustomPlayerAdapter.OnPlayerListener {
    final String mMainActivity = "MainActivity";
    MainActivityPresenter presenter;
    PlayerLocalProfile playerLocalProfile;

    Button createNewPlayerBtn;
    RecyclerView playerlistRv;

    Intent intent;

    List<Player> loadedPlayerList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        createNewPlayerBtn = findViewById(R.id.create_player);
        playerlistRv = findViewById(R.id.recyclerView);

        playerLocalProfile = new PlayerLocalProfile(this);

        new PopulateScene(new SceneLocalDb(this)).insertData();

        PlayerLocalDb playerLocalDb = new PlayerLocalDb(this);
        presenter = new MainActivityPresenter(playerLocalDb, this);
        presenter.loadPlayers();

        createNewPlayerBtn.setOnClickListener(this);
    }

    @Override
    public void loadedPlayers(List<Player> playerList) {
        Log.d(mMainActivity, "Players:"+ playerList);
        loadedPlayerList = playerList;

        if(playerList.size() > 0){
            playerlistRv.setHasFixedSize(true);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
            playerlistRv.setLayoutManager(layoutManager);
            playerlistRv.addItemDecoration(new DividerItemDecoration(this,
                    DividerItemDecoration.VERTICAL));

            CustomPlayerAdapter customPlayerAdapter = new CustomPlayerAdapter(this,
                    playerList, this);

            playerlistRv.setAdapter(customPlayerAdapter);
        }else{
            // No player added yet
        }
    }

    @Override
    public void createPlayer() {
        String name = "Player"+Math.random();
        presenter.createPlayer(new Player(0, name, null));
    }

    @Override
    public void createdPlayer(Player player) {
        Log.d(mMainActivity, "Created player: "+ player.getName());

        // Set last scene_id as 0
        player.setLastSceneId(0);

        // Create new player profile
        //playerLocalProfile.createPlayer(player);

        // Reload players list
        presenter.loadPlayers();
    }

    public void displayError(String error){

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.create_player:
                createPlayer();
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPlayerListenerClick(int position) {
        intent = new Intent(this, SceneActivity.class);
        playerLocalProfile.createPlayer(loadedPlayerList.get(position));
        if(playerLocalProfile.isPlayer()){
            startActivity(intent);
        }
    }
}