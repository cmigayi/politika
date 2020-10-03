package com.example.polika.views;

import com.example.polika.data.Scene;

import java.util.List;

public interface SceneActivityView {
    public void initSceneContent(Scene scene);
    public void loadedScenes(List<Scene> sceneList);
    public void displayError(String message);
}
