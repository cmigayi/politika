package com.example.polika.localDatabases;

import android.content.Context;
import android.util.Log;
import com.example.polika.daoDatabases.ContentResponseDaoDatabase;
import com.example.polika.data.ContentResponse;
import com.example.polika.repositories.ContentResponseRepository;

import java.util.List;

public class ContentResponseLocalDb implements ContentResponseRepository {
    final String mContentResponseLocalDb = "ContentResponseLocalDb";
    ContentResponseDaoDatabase contentResponseDaoDatabase;

    public ContentResponseLocalDb(Context context) {
        contentResponseDaoDatabase = ContentResponseDaoDatabase.getInstance(context);
    }

    @Override
    public void createContentResponse(ContentResponse contentResponse,
                                      OnFinishedListener onFinishedListener) {
        try {
            Long status = contentResponseDaoDatabase.contentResponseDao().insertContentResponse(contentResponse);
            if (status > 0) {
                List<ContentResponse> contentResponseList =
                        contentResponseDaoDatabase.contentResponseDao().getLastInsertedContentResponse();
                onFinishedListener.onFinished(contentResponseList);
                Log.d(mContentResponseLocalDb, "Success01: " + contentResponseList.get(0).getId());
            }
        }catch (Exception e){
            onFinishedListener.onFailuire(e);
        }
    }

    @Override
    public void getContentResponses(OnFinishedListener onFinishedListener) {
        try {
            List<ContentResponse> contentResponseList =
                    contentResponseDaoDatabase.contentResponseDao().getContentResponses();
            onFinishedListener.onFinished(contentResponseList);
        }catch (Exception e){
            onFinishedListener.onFailuire(e);
        }
    }

    @Override
    public void getContentResponseBySceneContentId(int sceneContentId,
                                                   OnFinishedListener onFinishedListener) {
        try {
            List<ContentResponse> contentResponseList =
                    contentResponseDaoDatabase.contentResponseDao().getContentResponse(sceneContentId);
            onFinishedListener.onFinished(contentResponseList);
        }catch (Exception e){
            onFinishedListener.onFailuire(e);
        }
    }
}
