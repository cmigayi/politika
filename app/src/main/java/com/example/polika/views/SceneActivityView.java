package com.example.polika.views;

import com.example.polika.data.Scene;

public interface SceneActivityView {
    public void initSceneContent(Scene scene);
    public void displayError(String message);
}
