package com.example.simplynote.room.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "CheckListItems")
public class ChecklistItem {

    @PrimaryKey(autoGenerate = true)
    private long id;

    @ColumnInfo(name = "content")
    private  String content;

    @ColumnInfo(name = "checklistId")
    private long checkListId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getCheckListId() {
        return checkListId;
    }

    public void setCheckListId(long checkListId) {
        this.checkListId = checkListId;
    }
}
