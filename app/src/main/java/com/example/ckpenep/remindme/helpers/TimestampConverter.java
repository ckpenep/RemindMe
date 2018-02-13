package com.example.ckpenep.remindme.helpers;

import android.arch.persistence.room.TypeConverter;

import com.example.ckpenep.remindme.constants.Constants;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ckpenep on 12.02.2018.
 */

public class TimestampConverter {
    static DateFormat df = new SimpleDateFormat(Constants.TIME_STAMP_FORMAT);

    @TypeConverter
    public static Date fromTimestamp(String value) {
        if (value != null) {
            try {
                return df.parse(value);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return null;
        } else {
            return null;
        }
    }

    @TypeConverter
    public static String dateToTimestamp(Date value) {

        return value == null ? null : df.format(value);
    }
}
