package com.example.polika.localDatabases;

import android.content.Context;
import android.util.Log;
import com.example.polika.daoDatabases.ProfileDaoDatabase;
import com.example.polika.data.Profile;
import com.example.polika.repositories.ProfileRepository;

import java.util.List;

public class ProfileLocalDb implements ProfileRepository {
    final String mProfileLocalDb = "ProfileLocalDb";
    ProfileDaoDatabase profileDaoDatabase;

    public ProfileLocalDb(Context context) {
        profileDaoDatabase = ProfileDaoDatabase.getInstance(context);
    }

    @Override
    public void createProfile(Profile profile, OnFinishedListener onFinishedListener) {
        try {
            Long status = profileDaoDatabase.profileDao().insertProfile(profile);
            if (status > 0) {
                List<Profile> profileList = profileDaoDatabase.profileDao().getLastInsertedProfile();
                onFinishedListener.onFinished(profileList);
                Log.d(mProfileLocalDb, "Success01: " + profileList.get(0).getId());
            }
        }catch (Exception e){
            onFinishedListener.onFailuire(e);
        }
    }

    @Override
    public void getProfiles(OnFinishedListener onFinishedListener) {
        try {
            List<Profile> profileList = profileDaoDatabase.profileDao().getProfiles();
            onFinishedListener.onFinished(profileList);
        }catch (Exception e){
            onFinishedListener.onFailuire(e);
        }
    }

    @Override
    public void getProfileByPlayerId(int playerId, OnFinishedListener onFinishedListener) {
        try {
            List<Profile> profileList = profileDaoDatabase.profileDao().getProfile(playerId);
            onFinishedListener.onFinished(profileList);
        }catch (Exception e){
            onFinishedListener.onFailuire(e);
        }
    }
}
