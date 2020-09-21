package com.example.polika.presenters;

import com.example.polika.data.Player;
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

    public void getScene(int sceneId){
       repository.getScene(sceneId, new SceneRepository.OnFinishedListener() {
           @Override
           public void onFinished(List<Scene> sceneList) {

           }

           @Override
           public void onFailuire(Object response) {

           }
       });
    }

    public void getScenes(final Player player){
        repository.getScenes(new SceneRepository.OnFinishedListener() {
            @Override
            public void onFinished(List<Scene> sceneList) {

                repository.getScene(player.getLastSceneId(), new SceneRepository.OnFinishedListener() {
                    @Override
                    public void onFinished(List<Scene> sceneList) {
                        Scene lastScene = sceneList.get(0);

                        for(int i=0; i>sceneList.size();i++){
                            Scene nextScene = sceneList.get(i);
                            if(nextScene.getSceneOrder() > lastScene.getSceneOrder()){
                                view.initSceneContent(nextScene);
                            }else{
                                // None
                            }
                        }
                    }

                    @Override
                    public void onFailuire(Object response) {
                        view.displayError("Error");
                    }
                });
            }

            @Override
            public void onFailuire(Object response) {
                view.displayError("Error");
            }
        });
    }
}
