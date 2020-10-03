package com.example.polika;

import android.os.Bundle;

import com.example.polika.adapters.CustomPlayerAdapter;
import com.example.polika.adapters.CustomSceneAdapter;
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
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class SceneActivity extends AppCompatActivity implements SceneActivityView, CustomSceneAdapter.OnSceneListener {
    public static String mSceneActivity = "SceneActivity";
    PlayerLocalProfile playerLocalProfile;
    Player player;

    SceneActivityPresenter presenter;

    RecyclerView sceneListRv;

    SceneLocalDb sceneLocalDb;

    List<Scene> loadedSceneList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scene);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        playerLocalProfile = new PlayerLocalProfile(this);
        player = playerLocalProfile.getPlayer();

        sceneListRv = findViewById(R.id.recyclerView);

        Log.d(mSceneActivity, "Player: "+player.getName());

        sceneLocalDb = new SceneLocalDb(this);
        presenter = new SceneActivityPresenter(sceneLocalDb, this);
        presenter.getScenes();
    }

    @Override
    public void initSceneContent(Scene scene) {
        Log.d(mSceneActivity, "Scene order: "+scene.getSceneRank());
    }

    @Override
    public void loadedScenes(List<Scene> sceneList) {
        Log.d(mSceneActivity, "Scenes:"+ sceneList);
        loadedSceneList= sceneList;

        if(sceneList.size() > 0){
            sceneListRv.setHasFixedSize(true);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
            sceneListRv.setLayoutManager(layoutManager);
            sceneListRv.addItemDecoration(new DividerItemDecoration(this,
                    DividerItemDecoration.VERTICAL));

            CustomSceneAdapter customSceneAdapter = new CustomSceneAdapter(this,
                    sceneList, this);

            sceneListRv.setAdapter(customSceneAdapter);
        }else{
            // No player added yet
        }
    }

    @Override
    public void displayError(String message) {

    }

    @Override
    public void onSceneListenerClick(int position) {

    }
}