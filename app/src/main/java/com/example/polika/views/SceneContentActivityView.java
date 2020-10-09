package com.example.polika.views;

import com.example.polika.data.SceneContent;

import java.util.List;

public interface SceneContentActivityView {
    public void loadedSceneContent(List<SceneContent> sceneContentList);
    public void displayError(String message);
}
