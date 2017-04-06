package com.two_six_mafia.root.waterapp.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


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
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DBContract.Users.USER_TABLE_DELETE_ENTRIES);
        onCreate(db);
    }
/*
    public void saveToDB(Person person) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DBContract.Users.KEY_NAME, person.getName());
        values.put(DBContract.Users.KEY_USERNAME, person.getUsername());
        values.put(DBContract.Users.KEY_PASSWORD, person.getPassword());
        values.put(DBContract.Users.KEY_EMAIL, person.getEmail());
        values.put(DBContract.Users.KEY_USERTYPE, person.getUserType().toString());
        db.insert(DBContract.Users.TABLE_NAME, null, values);
        db.close();
    }*/

    /*public HashMap<String, Person> getRegisteredUsers() {
        HashMap<String, Person> users = new HashMap<String, Person>();
        String selectQuerey = "SELECT * FROM " + DBContract.Users.TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuerey, null);
        if (cursor.moveToFirst()) {
            do {
                Person person = new Person();
                try {
                    person.setName(cursor.getString(0));
                    person.setUsername(cursor.getString(1));
                    person.setPassword(cursor.getString(2));
                    person.setEmail(cursor.getString(3));
                    String type = cursor.getString(4);
                    switch (type) {
                        case "User":
                            person.setUserType(UserType.USER);
                            break;
                        case "Worker":
                            person.setUserType(UserType.WORKER);
                            break;
                        case "Manager":
                            person.setUserType(UserType.MANAGER);
                            break;
                        case "Admin":
                            person.setUserType(UserType.ADMIN);
                            break;
                        default:
                            person.setUserType(UserType.USER);
                            break;
                    }
                } catch (Exception e) {
                    return null;
                }
                users.put(person.getUsername(), person);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return users;
    } */
}
