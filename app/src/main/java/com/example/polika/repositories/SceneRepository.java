package com.example.polika.repositories;

import com.example.polika.data.Scene;

import java.util.List;

public interface SceneRepository {
    public interface OnFinishedListener{
        void onFinished(List<Scene> sceneList);
        void onFailuire(Throwable t);
    }

    public void createScene(Scene scene, OnFinishedListener onFinishedListener);
    public void createSceneByList(List<Scene> sceneList, OnFinishedListener onFinishedListener);
    public void getScenes(OnFinishedListener onFinishedListener);
    public void getScene(int sceneId, OnFinishedListener onFinishedListener);
}
