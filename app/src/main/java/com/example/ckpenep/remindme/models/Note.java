package com.example.ckpenep.remindme.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.example.ckpenep.remindme.helpers.TimestampConverter;

import java.util.Date;

/**
 * Created by ckpenep on 07.02.2018.
 */

@Entity
public class Note {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "note_id")
    public long mId;

    @ColumnInfo(name = "title")
    public String mTitle;

    @ColumnInfo(name = "created_date")
    @TypeConverters(TimestampConverter.class)
    public Date createDate;

    @ColumnInfo(name = "favorite")
    public boolean isFavorite;

    public Note() {
        createDate = new Date();
    }

    public Note(String title, Date date)
    {
        mTitle = title;
        createDate = date;
    }
}
