package com.example.polika;

import android.util.Log;

import com.example.polika.data.Scene;
import com.example.polika.utils.ManageSceneList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ManageSceneListTest {
    List<Scene> sceneList;
    ManageSceneList manageSceneList;

    @Before
    public void setUp() throws Exception {
        sceneList = new ArrayList<>();
        manageSceneList = new ManageSceneList();
    }

    @After
    public void tearDown() throws Exception {
        sceneList = null;
        manageSceneList = null;
    }

    @Test
    public void sortListByRank_correct(){
        Scene scene = new Scene();
        scene.setSceneRank(3);
        sceneList.add(scene);

        Scene scene1 = new Scene();
        scene1.setSceneRank(2);
        sceneList.add(scene1);

        assertEquals(2, manageSceneList.sortListByRank(sceneList).get(0).getSceneRank());
        assertEquals(3, manageSceneList.sortListByRank(sceneList).get(1).getSceneRank());
    }
}
