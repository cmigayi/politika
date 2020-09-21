package com.example.polika.localProfiles;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.polika.data.Player;

public class PlayerLocalProfile {
    final static String mPlayerLocalProfile = "PlayerLocalProfile";
    SharedPreferences localProfile;
    SharedPreferences.Editor editor;

    public static final String PLAYER_ID = "player_id";
    public static final String NAME = "name";
    public static final String LAST_SCENE = "last_scene";
    public static final String DATETIME = "date_time";

    public PlayerLocalProfile(Context context) {
        localProfile = context.getSharedPreferences("profile", 0);
        editor = localProfile.edit();
    }

    public void createPlayer(Player player){
        editor.putInt(PLAYER_ID, player.getId());
        editor.putString(NAME, player.getName());
        editor.putInt(LAST_SCENE, player.getLastSceneId());
        editor.putString(DATETIME, player.getDateTime());
        editor.commit();
    }

    public Player getPlayer(){
        Player player = new Player(
                localProfile.getInt(PLAYER_ID, -1),
                localProfile.getString(NAME, ""),
                localProfile.getString(DATETIME, "")
        );
        player.setLastSceneId(localProfile.getInt(LAST_SCENE, -1));
        return player;
    }

    public boolean isPlayer(){
        if(getPlayer() == null){
            return false;
        }
        return true;
    }

    public void clearPlayerData(){
        editor.clear();
        editor.commit();
    }
}
