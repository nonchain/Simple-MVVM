package com.example.jmm.RoomDB;

import androidx.room.Database;
import androidx.room.RoomDatabase;

// CREATE DATABASE

@Database(entities = Information.class, version = 1)
public abstract class InformationRoomDataBase extends RoomDatabase {
}
