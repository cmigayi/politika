package com.example.polika.daos;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.polika.data.ContentResponse;

import java.util.List;

@Dao
public interface ContentResponseDao {
    @Query("SELECT * FROM content_responses ORDER BY id DESC")
    public List<ContentResponse> getContentResponses();

    @Insert
    public Long insertContentResponse(ContentResponse contentResponse);

    @Query("SELECT * FROM content_responses ORDER BY id DESC LIMIT 1")
    public List<ContentResponse> getLastInsertedContentResponse();

    @Query("SELECT * FROM content_responses WHERE id = :contentResponseId")
    public List<ContentResponse> getContentResponse(int contentResponseId);
}
