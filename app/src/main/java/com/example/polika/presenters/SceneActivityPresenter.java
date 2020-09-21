package com.example.polika.presenters;

import com.example.polika.data.Scene;
import com.example.polika.repositories.SceneRepository;
import com.example.polika.views.SceneActivityView;

import java.util.List;

public class SceneActivityPresenter {
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
            public void onFailuire(Object response) {

            }
        });
    }
}
