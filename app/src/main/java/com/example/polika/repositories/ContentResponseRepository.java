package com.example.polika.repositories;

import com.example.polika.data.ContentResponse;

import java.util.List;

public interface ContentResponseRepository {
    public interface OnFinishedListener{
        void onFinished(List<ContentResponse> contentResponseList);
        void onFailuire(Object response);
    }

    public void createContentResponse(ContentResponse contentResponse, OnFinishedListener onFinishedListener);
    public void getContentResponses(OnFinishedListener onFinishedListener);
    public void getContentResponseBySceneContentId(int sceneContentId, OnFinishedListener onFinishedListener);
}
