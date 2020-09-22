package com.example.polika.repositories;

import com.example.polika.data.ResponseConsequence;

import java.util.List;

public interface ResponseConsequenceRepository {
    public interface OnFinishedListener{
        void onFinished(List<ResponseConsequence> responseConsequence);
        void onFailuire(Object response);
    }

    public void createResponseConsequence(ResponseConsequence responseConsequence, OnFinishedListener onFinishedListener);
    public void getResponseConsequences(OnFinishedListener onFinishedListener);
    public void getResponseConsequenceByContentResponseId(int contentResponseId, OnFinishedListener onFinishedListener);
}
