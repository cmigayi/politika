package com.example.polika.repositories;

import com.example.polika.data.Scene;
import com.example.polika.data.SceneContent;

import java.util.List;

public interface SceneContentRepository {
    public interface OnFinishedListener{
        void onFinished(List<SceneContent> sceneContentList);
        void onFailuire(Throwable t);
    }

    public void createSceneContent(SceneContent sceneContent, OnFinishedListener onFinishedListener);
    public void createSceneContentByList(List<SceneContent> sceneContentList,
                                         SceneContentRepository.OnFinishedListener onFinishedListener);
    public void getSceneContents(OnFinishedListener onFinishedListener);
    public void getSceneContent(int sceneContentId, OnFinishedListener onFinishedListener);
}
