package com.example.polika.daos;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.polika.data.Scene;
import java.util.List;

@Dao
public interface SceneDao {
    @Query("SELECT * FROM scenes ORDER BY id DESC")
    public List<Scene> getScenes();

    @Insert
    public void insertScenes(Scene... scenes);

    @Insert
    public List<Long> insertSceneList(List<Scene> sceneList);

    @Insert
    public Long insertScene(Scene scene);

    @Query("SELECT * FROM scenes ORDER BY id DESC LIMIT 1")
    public List<Scene> getLastInsertedScene();

    @Query("SELECT * FROM scenes WHERE id = :sceneId")
    public List<Scene> getScene(int sceneId);
}
