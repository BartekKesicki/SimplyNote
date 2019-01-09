package com.example.simplynote.room.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Notes")
public class Note {
    @PrimaryKey
    private long id;

    @ColumnInfo(name = "content")
    private  String content;

    @ColumnInfo(name = "creationDate")
    private  String creationDate;
}
