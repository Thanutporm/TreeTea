package com.example.emergencyphone.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "phone.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "bubbletea";
    public static final String COL_ID = "_id";
    public static final String COL_TITLE = "title";
    public static final String COL_NUMBER = "number";
    public static final String COL_LOCATION = "location";

    private static final String SQL_CREATE_TABLE_TEA
            = "CREATE TABLE " + TABLE_NAME + "("
            + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COL_TITLE + " TEXT,"
            + COL_NUMBER + " TEXT,"
            + COL_LOCATION + " TEXT"
            + ")";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE_TEA);

        ContentValues cv = new ContentValues();
        cv.put(COL_TITLE, "Coco");
        cv.put(COL_NUMBER, "40");
        cv.put(COL_LOCATION, "Nakornpathom, Sanamchan, 73000, *opposite Silpakorn University");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_TITLE, "Milk");
        cv.put(COL_NUMBER, "40");
        cv.put(COL_LOCATION, "Nakornpathom, Sanamchan, 73000, *opposite Silpakorn University");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_TITLE, "Milk Tea");
        cv.put(COL_NUMBER, "55");
        cv.put(COL_LOCATION, "Nakornpathom, Sanamchan, 73000, *opposite Silpakorn University");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_TITLE, "Green Tea");
        cv.put(COL_NUMBER, "55");
        cv.put(COL_LOCATION, "Nakornpathom, Sanamchan, 73000, *opposite Silpakorn University");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_TITLE, "Coffee");
        cv.put(COL_NUMBER, "85");
        cv.put(COL_LOCATION, "Nakornpathom, Sanamchan, 73000, *opposite Silpakorn University");
        db.insert(TABLE_NAME, null, cv);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
