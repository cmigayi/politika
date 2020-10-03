package com.example.polika.preload;

import android.util.Log;

import com.example.polika.commons.AppExecutors;
import com.example.polika.data.Scene;
import com.example.polika.repositories.SceneRepository;

import java.util.ArrayList;
import java.util.List;

public class PopulateScene {
    final static String mPopulateScene = "PopulateScene";
    SceneRepository repository;
    List<Scene> sceneList;

    public PopulateScene(SceneRepository repository) {
        this.repository = repository;
        initScenes();
    }

    public void initScenes(){
        sceneList = new ArrayList<>();

        Scene scene = new Scene(0, "Scene1", 1, null);
        sceneList.add(scene);

        Scene scene2 = new Scene(0, "Scene2", 2, null);
        sceneList.add(scene2);

        Scene scene3 = new Scene(0, "Scene3", 3, null);
        sceneList.add(scene3);

        Scene scene4 = new Scene(0, "Scene4", 4, null);
        sceneList.add(scene4);
    }

    public int dataSize(){
        return sceneList.size();
    }

    public void insertData(){
        repository.createSceneByList(sceneList, new SceneRepository.OnFinishedListener() {
            @Override
            public void onFinished(final List<Scene> sceneList) {
                AppExecutors.getInstance().mainThread().execute(new Runnable() {
                    @Override
                    public void run() {
                        Log.d(mPopulateScene, "Populated data: "+sceneList);
                    }
                });
            }

            @Override
            public void onFailuire(final Throwable t) {
                AppExecutors.getInstance().mainThread().execute(new Runnable() {
                    @Override
                    public void run() {
                        Log.d(mPopulateScene, "Error: "+t.getMessage());
                    }
                });
            }
        });
    }
}
