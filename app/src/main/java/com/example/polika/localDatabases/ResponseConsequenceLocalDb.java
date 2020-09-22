package com.example.polika.localDatabases;

import android.content.Context;
import android.util.Log;
import com.example.polika.daoDatabases.ResponseConsequenceDaoDatabase;
import com.example.polika.data.ResponseConsequence;
import com.example.polika.repositories.ResponseConsequenceRepository;

import java.util.List;

public class ResponseConsequenceLocalDb implements ResponseConsequenceRepository {
    final static String mResponseConsequenceLocalDb = "ResponseConsequenceDb";
    ResponseConsequenceDaoDatabase responseConsequenceDaoDatabase;

    public ResponseConsequenceLocalDb(Context context) {
        responseConsequenceDaoDatabase = ResponseConsequenceDaoDatabase.getInstance(context);
    }

    @Override
    public void createResponseConsequence(ResponseConsequence responseConsequence,
                                          OnFinishedListener onFinishedListener) {
        try {
            Long status = responseConsequenceDaoDatabase.responseConsequenceDao().
                    insertResponseConsequence(responseConsequence);
            if (status > 0) {
                List<ResponseConsequence> responseConsequenceList =
                        responseConsequenceDaoDatabase.responseConsequenceDao().getLastInsertedResponseConsequence();
                onFinishedListener.onFinished(responseConsequenceList);
                Log.d(mResponseConsequenceLocalDb, "Success01: " + responseConsequenceList.get(0).getId());
            }
        }catch (Exception e){
            onFinishedListener.onFailuire(e);
        }
    }

    @Override
    public void getResponseConsequences(OnFinishedListener onFinishedListener) {
        try {
            List<ResponseConsequence> responseConsequenceList =
                    responseConsequenceDaoDatabase.responseConsequenceDao().getResponseConsequences();
            onFinishedListener.onFinished(responseConsequenceList);
        }catch (Exception e){
            onFinishedListener.onFailuire(e);
        }
    }

    @Override
    public void getResponseConsequenceByContentResponseId(int contentResponseId,
                                                          OnFinishedListener onFinishedListener) {
        try {
            List<ResponseConsequence> responseConsequenceList =
                    responseConsequenceDaoDatabase.responseConsequenceDao().getResponseConsequence(contentResponseId);
            onFinishedListener.onFinished(responseConsequenceList);
        }catch (Exception e){
            onFinishedListener.onFailuire(e);
        }
    }
}
