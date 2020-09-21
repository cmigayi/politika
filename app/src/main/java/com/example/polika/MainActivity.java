package com.example.polika;

import android.os.Bundle;

import com.example.polika.data.Player;
import com.example.polika.localDatabases.PlayerLocalDb;
import com.example.polika.localProfiles.PlayerLocalProfile;
import com.example.polika.presenters.MainActivityPresenter;
import com.example.polika.views.MainActivityView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainActivityView {
    final String mMainActivity = "MainActivity";
    MainActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        PlayerLocalDb playerLocalDb = new PlayerLocalDb(this);
        presenter = new MainActivityPresenter(playerLocalDb, this);
        presenter.loadPlayers();
    }

    @Override
    public void loadPlayers(List<Player> playerList) {
        Log.d(mMainActivity, "Players"+ playerList);
    }

    public void displayError(String error){

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
}