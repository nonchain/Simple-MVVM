package com.example.jmm.RoomDB;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

// CREATE FUNCTIONS

@Dao // SO IMPORTANT
public interface InformationDao {

    // SELECT ALL DATA
    @Query("SELECT * FROM information")
    LiveData<List<Information>> getAllInformation();

    // SELECT ONE DATA
    @Query("SELECT * FROM information WHERE id=:information_id")
    LiveData<Information> getInformation(int information_id);

    @Insert
    void insertInformation(Information info);

    @Update
    void updateInformation(Information info);

    // THE DELETE FUNCTION IS NOT VOID
    // BECAUSE WE USE ID FOR FINDING ITEM
    @Delete
    int deleteInformation(Information info);
}
