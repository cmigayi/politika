package com.example.polika.utils;

import android.util.Log;

import com.example.polika.data.Scene;

import java.util.ArrayList;
import java.util.List;

public class ManageSceneList {

    public List<Scene> sortListByRank(List<Scene> sceneList){
        List<Scene> rankedSceneList = new ArrayList<>();

        for(int i=0; i<sceneList.size();i++){
            // 10,1,40,5,3
            for(int j=0; j<sceneList.size();j++){
                if(sceneList.get(j).getSceneRank() < sceneList.get(i).getSceneRank()){
                    rankedSceneList.add(sceneList.get(i));
                }
            }
        }
        return rankedSceneList;
    }
}
