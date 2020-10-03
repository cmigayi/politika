package com.example.polika.presenters;

import android.util.Log;

import com.example.polika.commons.AppExecutors;
import com.example.polika.data.Player;
import com.example.polika.data.Scene;
import com.example.polika.repositories.SceneRepository;
import com.example.polika.views.SceneActivityView;

import java.util.List;

public class SceneActivityPresenter {
    final static String mSceneActivityPresenter = "SceneActivityPresenter";
    SceneRepository repository;
    SceneActivityView view;

    public SceneActivityPresenter(SceneRepository repository, SceneActivityView view) {
        this.repository = repository;
        this.view = view;
    }

    public void createScene(Scene scene){
        repository.createScene(scene, new SceneRepository.OnFinishedListener() {
            @Override
            public void onFinished(List<Scene> sceneList) {

            }

            @Override
            public void onFailuire(Throwable t) {

            }
        });
    }

    public void getScene(int sceneId){
       repository.getScene(sceneId, new SceneRepository.OnFinishedListener() {
           @Override
           public void onFinished(List<Scene> sceneList) {

           }

           @Override
           public void onFailuire(Throwable t) {

           }
       });
    }

    public void getScenes(){
        repository.getScenes(new SceneRepository.OnFinishedListener() {
            @Override
            public void onFinished(List<Scene> sceneList) {
                Log.d(mSceneActivityPresenter, "Scenes: "+sceneList);
                AppExecutors.getInstance().mainThread().execute(new Runnable() {
                    @Override
                    public void run() {
                       view.loadedScenes(sceneList);
                    }
                });
            }

            @Override
            public void onFailuire(Throwable t) {
                AppExecutors.getInstance().mainThread().execute(new Runnable() {
                    @Override
                    public void run() {
                        view.displayError("Error");
                    }
                });
            }
        });
    }
}
