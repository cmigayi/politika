package com.example.polika.daos;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.polika.data.ResponseConsequence;

import java.util.List;

@Dao
public interface ResponseConsequenceDao {
    @Query("SELECT * FROM response_consequences ORDER BY id DESC")
    public List<ResponseConsequence> getResponseConsequences();

    @Insert
    public Long insertResponseConsequence(ResponseConsequence responseConsequence);

    @Query("SELECT * FROM response_consequences ORDER BY id DESC LIMIT 1")
    public List<ResponseConsequence> getLastInsertedResponseConsequence();

    @Query("SELECT * FROM response_consequences WHERE id = :responseConsequenceId")
    public List<ResponseConsequence> getResponseConsequence(int responseConsequenceId);
}
