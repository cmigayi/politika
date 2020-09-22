package com.example.polika.daos;

import com.example.polika.data.Profile;
import java.util.List;

@Dao
public interface ProfileDao {
    @Query("SELECT * FROM profiles ORDER BY id DESC")
    public List<Profile> getProfiles();

    @Insert
    public Long insertProfile(Profile profile);

    @Query("SELECT * FROM profiles ORDER BY id DESC LIMIT 1")
    public List<Profile> getLastInsertedProfile();

    @Query("SELECT * FROM profiles WHERE id = :profileId")
    public List<Profile> getProfile(int profileId);
}
