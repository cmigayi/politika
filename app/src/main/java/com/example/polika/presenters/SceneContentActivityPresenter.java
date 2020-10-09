package com.example.polika.presenters;

import android.util.Log;

import com.example.polika.commons.AppExecutors;
import com.example.polika.data.SceneContent;
import com.example.polika.repositories.SceneContentRepository;
import com.example.polika.views.SceneContentActivityView;

import java.util.List;

public class SceneContentActivityPresenter {
    final static String mSceneContentActivityPresenter = "SceneContentActivity";
    SceneContentRepository repository;
    SceneContentActivityView view;

    public SceneContentActivityPresenter(SceneContentRepository repository, SceneContentActivityView view) {
        this.repository = repository;
        this.view = view;
    }

    public void loadSceneContent(int sceneId){
        repository.getSceneContent(sceneId, new SceneContentRepository.OnFinishedListener() {
            @Override
            public void onFinished(List<SceneContent> sceneContentList) {
                Log.d(mSceneContentActivityPresenter, "SceneContent: "+sceneContentList);
                AppExecutors.getInstance().mainThread().execute(new Runnable() {
                    @Override
                    public void run() {
                        view.loadedSceneContent(sceneContentList);
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
