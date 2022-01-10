package com.example.jmm.RoomDB;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

// CREATE COLUMNS

@Entity(tableName = "information")
public class Information {

    // To create id auto if type is Integer
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    int id;

    @ColumnInfo(name = "username")
    String user_name;

    public Information() {
    }

    public Information(int id, String user_name) {
        this.id = id;
        this.user_name = user_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
}
