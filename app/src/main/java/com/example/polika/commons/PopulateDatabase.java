//package com.example.polika.commons;
//
//import android.content.Context;
//import android.util.Log;
//
//import com.example.polika.data.Scene;
//import com.example.polika.localDatabases.SceneLocalDb;
//import com.example.polika.repositories.SceneRepository;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class PopulateDatabase {
//    public static String mPopulateDatabase;
//    SceneLocalDb sceneLocalDb;
//
//    public PopulateDatabase(Context context) {
//        sceneLocalDb = new SceneLocalDb(context);
//        populateScenes();
//    }
//
//    public void populateScenes(){
//        Scene scene = new Scene(0, "scene 1", 1, null);
//
//        List<Scene> sceneList = new ArrayList<>();
//        sceneList.add(scene);
//        sceneLocalDb.createSceneByList(sceneList, new SceneRepository.OnFinishedListener() {
//            @Override
//            public void onFinished(List<Scene> sceneList) {
//                Log.d(mPopulateDatabase, "Scenes inserted successful: "+sceneList.size());
//            }
//
//            @Override
//            public void onFailuire(Object response) {
//                Log.d(mPopulateDatabase, "Scenes inserted failed: "+response);
//            }
//        });
//    }
//}
