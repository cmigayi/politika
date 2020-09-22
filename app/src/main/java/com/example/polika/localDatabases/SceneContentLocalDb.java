package com.example.polika.localDatabases;

import android.content.Context;
import android.util.Log;
import com.example.polika.daoDatabases.SceneContentDaoDatabase;
import com.example.polika.data.SceneContent;
import com.example.polika.repositories.SceneContentRepository;
import java.util.List;

public class SceneContentLocalDb implements SceneContentRepository {
    final String mSceneContentDb = "SceneContentDb";
    SceneContentDaoDatabase sceneContentDaoDatabase;

    public SceneContentLocalDb(Context context) {
        sceneContentDaoDatabase = SceneContentDaoDatabase.getInstance(context);
    }

    @Override
    public void createSceneContent(SceneContent sceneContent, OnFinishedListener onFinishedListener) {
        try {
            Long status = sceneContentDaoDatabase.sceneContentDao().insertSceneContent(sceneContent);
            if (status > 0) {
                List<SceneContent> sceneContentList =
                        sceneContentDaoDatabase.sceneContentDao().getLastInsertedSceneContent();
                onFinishedListener.onFinished(sceneContentList);
                Log.d(mSceneContentDb, "Success01: " + sceneContentList.get(0).getId());
            }
        }catch (Exception e){
            onFinishedListener.onFailuire(e);
        }
    }

    @Override
    public void getSceneContents(OnFinishedListener onFinishedListener) {
        try {
            List<SceneContent> sceneContentList =
                    sceneContentDaoDatabase.sceneContentDao().getSceneContents();
            onFinishedListener.onFinished(sceneContentList);
        }catch (Exception e){
            onFinishedListener.onFailuire(e);
        }
    }

    @Override
    public void getSceneContent(int sceneContentId, OnFinishedListener onFinishedListener) {
        try {
            List<SceneContent> sceneContentList =
                    sceneContentDaoDatabase.sceneContentDao().getSceneContent(sceneContentId);
            onFinishedListener.onFinished(sceneContentList);
        }catch (Exception e){
            onFinishedListener.onFailuire(e);
        }
    }
}
