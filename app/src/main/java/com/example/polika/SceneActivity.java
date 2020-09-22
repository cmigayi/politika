package com.example.polika;

import android.os.Bundle;

import com.example.polika.data.Player;
import com.example.polika.data.Scene;
import com.example.polika.localDatabases.SceneLocalDb;
import com.example.polika.localProfiles.PlayerLocalProfile;
import com.example.polika.presenters.SceneActivityPresenter;
import com.example.polika.views.SceneActivityView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;

public class SceneActivity extends AppCompatActivity implements SceneActivityView {
    public static String mSceneActivity = "SceneActivity";
    PlayerLocalProfile playerLocalProfile;
    Player player;

    SceneActivityPresenter presenter;

    SceneLocalDb sceneLocalDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scene);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        playerLocalProfile = new PlayerLocalProfile(this);
        player = playerLocalProfile.getPlayer();

        sceneLocalDb = new SceneLocalDb(this);
        presenter = new SceneActivityPresenter(sceneLocalDb, this);
        presenter.getScenes(player);
    }

    @Override
    public void initSceneContent(Scene scene) {
        Log.d(mSceneActivity, "Scene order: "+scene.getSceneRank());
    }

    @Override
    public void displayError(String message) {

    }
}