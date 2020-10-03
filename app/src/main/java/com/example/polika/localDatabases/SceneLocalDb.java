package com.example.polika.localDatabases;

import android.content.Context;
import android.util.Log;

import com.example.polika.commons.AppExecutors;
import com.example.polika.daoDatabases.SceneDaoDatabase;
import com.example.polika.data.Scene;
import com.example.polika.repositories.SceneRepository;

import java.util.List;

public class SceneLocalDb implements SceneRepository {
    final String mSceneLocalDb = "SceneLocalDb";
    SceneDaoDatabase sceneDaoDatabase;

    public SceneLocalDb(Context context) {
        sceneDaoDatabase = SceneDaoDatabase.getInstance(context);
    }

    @Override
    public void createScene(Scene scene, OnFinishedListener onFinishedListener) {
        try {
            Long status = sceneDaoDatabase.sceneDao().insertScene(scene);
            if (status > 0) {
                List<Scene> sceneList = sceneDaoDatabase.sceneDao().getLastInsertedScene();
                onFinishedListener.onFinished(sceneList);
                Log.d(mSceneLocalDb, "Success01: " + sceneList.get(0).getId());
            }
        }catch (Exception e){
            onFinishedListener.onFailuire(e);
        }
    }

    @Override
    public void createSceneByList(final List<Scene> sceneList, final OnFinishedListener onFinishedListener) {
        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                try {
                    List<Long> statusList = sceneDaoDatabase.sceneDao().insertSceneList(sceneList);
                    onFinishedListener.onFinished(sceneList);
                    Log.d(mSceneLocalDb, "Success01: " + statusList);
                }catch (Exception e){
                    onFinishedListener.onFailuire(e);
                }
            }
        });
    }

    @Override
    public void getScenes(OnFinishedListener onFinishedListener) {
        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                try {
                    List<Scene> sceneList = sceneDaoDatabase.sceneDao().getScenes();
                    Log.d(mSceneLocalDb, "Success01: " + sceneList);
                    onFinishedListener.onFinished(sceneList);
                }catch (Exception e){
                    onFinishedListener.onFailuire(e);
                }
            }
        });
    }

    @Override
    public void getScene(int sceneId, OnFinishedListener onFinishedListener) {
        try {
            List<Scene> sceneList = sceneDaoDatabase.sceneDao().getScene(sceneId);
            onFinishedListener.onFinished(sceneList);
        }catch (Exception e){
            onFinishedListener.onFailuire(e);
        }
    }
}
