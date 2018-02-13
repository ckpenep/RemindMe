package com.example.ckpenep.remindme.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.ckpenep.remindme.models.Note;

import java.util.List;

/**
 * Created by ckpenep on 11.02.2018.
 */

@Dao
public interface DataDao {
    @Insert
    void insert(Note note);

    @Delete
    void delete(Note note);

    @Query("SELECT * FROM Note")
    List<Note> getAllData();

    //пример запроса с выборкой
    //@Query("SELECT * FROM Note WHERE title LIKE :title")
    //List<Note> getByTitle(String title);
}
