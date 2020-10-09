package com.example.polika;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.polika.data.SceneContent;
import com.example.polika.localDatabases.SceneContentLocalDb;
import com.example.polika.presenters.SceneContentActivityPresenter;
import com.example.polika.views.SceneContentActivityView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SceneContentActivity extends AppCompatActivity
        implements View.OnClickListener, SceneContentActivityView {
    final static String mSceneContentActivity = "ContentActivity";
    SceneContentActivityPresenter presenter;

    TextView sceneContentTv;
    Button nextBtn;

    int rank_num = 0;
    List<SceneContent> sceneContentList2;
    int[] contentRanks;
    SceneContent currentSceneContent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scene_content);

        sceneContentTv = findViewById(R.id.scene_content_tv);
        nextBtn = findViewById(R.id.next_btn);

        SceneContentLocalDb sceneContentLocalDb =  new SceneContentLocalDb(this);
        presenter = new SceneContentActivityPresenter(sceneContentLocalDb, this);
        presenter.loadSceneContent(1);

        nextBtn.setOnClickListener(this);
    }

    @Override
    public void loadedSceneContent(List<SceneContent> sceneContentList) {
        sceneContentList2 = sceneContentList;
        Log.d(mSceneContentActivity, "SceneContent: "+sceneContentList);

        contentRanks = getSceneContentSortedRanks(sceneContentList);

        // Display the first scene content
        currentSceneContent = getCurrentRankedSceneContent(0, sceneContentList);

        sceneContentTv.setText(currentSceneContent.getContent());
    }

    @Override
    public void displayError(String message) {

    }

    public SceneContent getCurrentRankedSceneContent(int rank_num, List<SceneContent> sceneContentList){
        if(rank_num < sceneContentList.size()){
            // Search if scene with such ranking exists
            for(int i=0;i<sceneContentList.size();i++){
                int rank = contentRanks[rank_num];
                if(rank == sceneContentList.get(i).getContentRank()){
                    currentSceneContent = sceneContentList.get(i);
                }
            }
        }
        return currentSceneContent;
    }

    public int[] getSceneContentSortedRanks(List<SceneContent> sceneContentList){
        contentRanks = new int[sceneContentList.size()];
        for(int i=0;i<sceneContentList.size();i++){
            contentRanks[i] = sceneContentList.get(i).getContentRank();
        }
        Arrays.sort(contentRanks);
        Log.d(mSceneContentActivity, "SceneContentRanks: "+Arrays.toString(contentRanks));
        return contentRanks;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.next_btn:
                rank_num = rank_num + 1;
                currentSceneContent = getCurrentRankedSceneContent(rank_num, sceneContentList2);
                sceneContentTv.setText(currentSceneContent.getContent());
                break;
        }
    }
}