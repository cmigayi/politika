package com.example.polika.preload;

import android.util.Log;

import com.example.polika.commons.AppExecutors;
import com.example.polika.data.Scene;
import com.example.polika.data.SceneContent;
import com.example.polika.repositories.SceneContentRepository;
import com.example.polika.repositories.SceneRepository;

import java.util.ArrayList;
import java.util.List;

public class PopulateSceneContent {
    final static String mPopulateSceneContent = "PopulateSceneContent";
    SceneContentRepository repository;
    List<SceneContent> sceneContentList;

    public PopulateSceneContent(SceneContentRepository repository) {
        this.repository = repository;
        initSceneContent();
    }

    private void initSceneContent(){
        sceneContentList = new ArrayList<>();

        String content1 = "You have decided to run for a position in the your local ward. " +
                "To improve your chances of being elected you must embark on building your " +
                "popularity with the local people";
        String content2 = "content 2";
        String content3 = "content 3";
        String content4 = "content 4";
        SceneContent sceneContent = new SceneContent();
        sceneContent.setSceneId(1);
        sceneContent.setContentType(0);
        sceneContent.setContent(content1);
        sceneContent.setContentRank(1);
        sceneContent.setDateTime(null);
        sceneContentList.add(sceneContent);

        SceneContent sceneContent1 = new SceneContent();
        sceneContent1.setSceneId(1);
        sceneContent1.setContentType(0);
        sceneContent1.setContent(content2);
        sceneContent1.setContentRank(2);
        sceneContent1.setDateTime(null);
        sceneContentList.add(sceneContent1);

        SceneContent sceneContent2 = new SceneContent();
        sceneContent2.setSceneId(1);
        sceneContent2.setContentType(0);
        sceneContent2.setContent(content4);
        sceneContent2.setContentRank(5);
        sceneContent2.setDateTime(null);
        sceneContentList.add(sceneContent2);

        SceneContent sceneContent3 = new SceneContent();
        sceneContent3.setSceneId(1);
        sceneContent3.setContentType(0);
        sceneContent3.setContent(content3);
        sceneContent3.setContentRank(4);
        sceneContent3.setDateTime(null);
        sceneContentList.add(sceneContent3);
    }

    public int dataSize(){
        return sceneContentList.size();
    }

    public void insertData(){
        repository.createSceneContentByList(sceneContentList, new SceneContentRepository.OnFinishedListener() {
            @Override
            public void onFinished(final List<SceneContent> createdSceneContentList) {
                AppExecutors.getInstance().mainThread().execute(new Runnable() {
                    @Override
                    public void run() {
                        Log.d(mPopulateSceneContent, "Populated data: "+createdSceneContentList);
                    }
                });
            }

            @Override
            public void onFailuire(final Throwable t) {
                AppExecutors.getInstance().mainThread().execute(new Runnable() {
                    @Override
                    public void run() {
                        Log.d(mPopulateSceneContent, "Error: "+t.getMessage());
                    }
                });
            }
        });
    }
}
