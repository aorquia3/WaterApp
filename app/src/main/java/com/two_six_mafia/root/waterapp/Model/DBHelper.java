package com.two_six_mafia.root.waterapp.Model;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Aaron on 4/4/2017.
 */

public final class DBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "model.db";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DBContract.Users.CREATE_USER_TABLE);
        db.execSQL(DBContract.Source.CREATE_SOURCE_TABLE);
        db.execSQL(DBContract.Purity.CREATE_SOURCE_TABLE);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DBContract.Users.USER_TABLE_DELETE_ENTRIES);
        db.execSQL(DBContract.Source.SOURCE_TABLE_DELETE_ENTRIES);
        db.execSQL(DBContract.Purity.PURITY_TABLE_DELETE_ENTRIES);
        onCreate(db);
    }
}
