package com.example.simplynote.room.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Users")
public class User {
    @PrimaryKey
    private long id;

    @ColumnInfo(name = "login")
    private String login;

    @ColumnInfo(name = "password")
    private String passowrd;
}
