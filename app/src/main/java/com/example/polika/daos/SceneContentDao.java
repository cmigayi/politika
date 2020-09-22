package com.example.polika.daos;

import com.example.polika.data.Scene;
import com.example.polika.data.SceneContent;

import java.util.List;

@Dao
public interface SceneContentDao {
    @Query("SELECT * FROM scene_contents ORDER BY id DESC")
    public List<SceneContent> getSceneContents();

    @Insert
    public void insertSceneContents(SceneContent... sceneContents);

    @Insert
    public List<Long> insertSceneContentList(List<SceneContent> sceneContentList);

    @Insert
    public Long insertSceneContent(SceneContent... sceneContent);

    @Query("SELECT * FROM scene_contents ORDER BY id DESC LIMIT 1")
    public List<SceneContent> getLastInsertedSceneContent();

    @Query("SELECT * FROM scene_contents WHERE id = :sceneContentId")
    public List<SceneContent> getSceneContent(int sceneContentId);
}

