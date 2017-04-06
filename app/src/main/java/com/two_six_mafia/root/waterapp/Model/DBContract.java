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
                + " (" + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + KEY_USERNAME + " TEXT,"
                + KEY_PASSWORD + " TEXT,"
                + KEY_NAME + " TEXT,"
                + KEY_EMAIL + " TEXT,"
                + KEY_USERTYPE + " TEXT)";

        public static final String USER_TABLE_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + TABLE_NAME;

    }

    public static class Source implements BaseColumns {

        public static final String TABLE_NAME = "sourceTable";
        public static final String KEY_LAT = "Latitude";
        public static final String KEY_LON = "Longitude";
        public static final String KEY_SOURCE = "SourceNumber";
        public static final String KEY_DATE = "Date";
        public static final String KEY_TIME = "Time";
        public static final String KEY_REPORTER = "Reporter";
        public static final String KEY_TYPE = "WaterType";
        public static final String KEY_CONDITION = "WaterCondition";

        public static final String CREATE_SOURCE_TABLE = "CREATE TABLE " + TABLE_NAME
                + " (" + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + KEY_LAT + " REAL,"
                + KEY_LON + " REAL,"
                + KEY_SOURCE + " INTEGER,"
                + KEY_DATE + " TEXT,"
                + KEY_TIME + " TEXT,"
                + KEY_REPORTER + " TEXT,"
                + KEY_TYPE + " TEXT,"
                + KEY_CONDITION + " TEXT)";

        public static final String SOURCE_TABLE_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + TABLE_NAME;

    }

    public static class Purity implements BaseColumns {

        public static final String TABLE_NAME = "purityTable";
        public static final String KEY_LAT = "Latitude";
        public static final String KEY_LON = "Longitude";
        public static final String KEY_REPORT = "reportNumber";
        public static final String KEY_DATE = "Date";
        public static final String KEY_TIME = "Time";
        public static final String KEY_REPORTER = "Reporter";
        public static final String KEY_CONDITION = "OverallCondition";
        public static final String KEY_VIRUS = "VirusPPM";
        public static final String KEY_CONTAMINANT = "ContaminantPPM";

        public static final String CREATE_SOURCE_TABLE = "CREATE TABLE " + TABLE_NAME
                + " (" + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + KEY_LAT + " REAL,"
                + KEY_LON + " REAL,"
                + KEY_REPORT + " INTEGER,"
                + KEY_DATE + " TEXT,"
                + KEY_TIME + " TEXT,"
                + KEY_REPORTER + " TEXT,"
                + KEY_CONDITION + " TEXT,"
                + KEY_VIRUS + " REAL,"
                + KEY_CONTAMINANT + " REAL)";

        public static final String PURITY_TABLE_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + TABLE_NAME;

    }
}
