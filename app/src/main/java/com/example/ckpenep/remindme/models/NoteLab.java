package com.example.ckpenep.remindme.models;

import android.content.Context;

import com.example.ckpenep.remindme.App;
import com.example.ckpenep.remindme.db.DatabaseHelper;

import java.util.List;

/**
 * Created by ckpenep on 08.02.2018.
 */

public class NoteLab {
    private static NoteLab sInstance;
    private List<Note> notes;

    private Context mContext;
    private DatabaseHelper databaseHelper;

    private NoteLab(Context context) {
        databaseHelper = App.getInstance().getDatabaseInstance();
        mContext = context.getApplicationContext();//контекст всего приложения , а не отдельной активности
    }

    public static NoteLab Instance(Context context) {
        if (sInstance == null) {
            sInstance = new NoteLab(context);
        }
        return sInstance;
    }

    public List<Note> getNotes() {
        try {
            return databaseHelper.getDataDao().getAllData();
        }
        catch (Exception ex){return null;}
    }

    public void addNote(Note note)
    {
        databaseHelper.getDataDao().insert(note);
    }

    public void deleteNote(Note note)
    {
        databaseHelper.getDataDao().delete(note);
    }
}
