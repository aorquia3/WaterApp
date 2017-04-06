package com.two_six_mafia.root.waterapp.Model;

import android.provider.BaseColumns;

/**
 * Created by Aaron on 4/5/2017.
 */

public class DBContract {
    private DBContract(){}

    public static class Users implements BaseColumns {

        public static final String TABLE_NAME = "userTable";
        public static final String KEY_NAME = "Name";
        public static final String KEY_USERNAME = "Username";
        public static final String KEY_PASSWORD = "Password";
        public static final String KEY_EMAIL = "Email";
        public static final String KEY_USERTYPE = "UserType";

        public static final String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_NAME
                + "(" + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + KEY_USERNAME + " TEXT,"
                + KEY_PASSWORD + " TEXT,"
                + KEY_NAME + " TEXT,"
                + KEY_EMAIL + " TEXT,"
                + KEY_USERTYPE + " TEXT)";

        public static final String USER_TABLE_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + TABLE_NAME;

    }
}
