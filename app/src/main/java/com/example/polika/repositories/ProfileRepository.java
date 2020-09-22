package com.example.polika.repositories;

import com.example.polika.data.Player;
import com.example.polika.data.Profile;

import java.util.List;

public interface ProfileRepository {
    public interface OnFinishedListener{
        void onFinished(List<Profile> profileList);
        void onFailuire(Object response);
    }

    public void createProfile(Profile profile, OnFinishedListener onFinishedListener);
    public void getProfiles(OnFinishedListener onFinishedListener);
    public void getProfileByPlayerId(int playerId, OnFinishedListener onFinishedListener);
}
