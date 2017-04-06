package com.two_six_mafia.root.waterapp.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aaron on 4/6/2017.
 */

public class Database {
    private SQLiteDatabase database;
    private DBHelper dbHelper;

    public Database(Context context) {
        dbHelper = new DBHelper(context);
        open();
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public long addUser(Person person) {
        ContentValues values = new ContentValues();
        values.put(DBContract.Users.KEY_NAME, person.getName());
        values.put(DBContract.Users.KEY_USERNAME, person.getUsername());
        values.put(DBContract.Users.KEY_EMAIL, person.getEmail());
        values.put(DBContract.Users.KEY_PASSWORD, person.getPassword());
        values.put(DBContract.Users.KEY_USERTYPE, person.getUserType().toString());

        return database.insert(DBContract.Users.TABLE_NAME, null, values);
    }

    public int updateUser(Person person, String name, String email, String password) {
        ContentValues values = new ContentValues();
        values.put(DBContract.Users.KEY_NAME,name);
        values.put(DBContract.Users.KEY_USERNAME, person.getUsername());
        values.put(DBContract.Users.KEY_EMAIL, email);
        values.put(DBContract.Users.KEY_PASSWORD, password);
        values.put(DBContract.Users.KEY_USERTYPE, person.getUserType().toString());

        return database.update(DBContract.Users.TABLE_NAME, values,
                String.format("%s = ?", DBContract.Users.KEY_USERNAME),
                new String[]{person.getUsername()});
    }

    public long addSource(WaterSource waterSource) {
        ContentValues values = new ContentValues();
        values.put(DBContract.Source.KEY_LAT, waterSource.getLocation().latitude);
        values.put(DBContract.Source.KEY_LON, waterSource.getLocation().longitude);
        values.put(DBContract.Source.KEY_SOURCE, waterSource.getSourceNumber());
        values.put(DBContract.Source.KEY_DATE, waterSource.getDate());
        values.put(DBContract.Source.KEY_TIME, waterSource.getTime());
        values.put(DBContract.Source.KEY_REPORTER, waterSource.getReporter());
        values.put(DBContract.Source.KEY_TYPE, waterSource.getWaterType().toString());
        values.put(DBContract.Source.KEY_CONDITION, waterSource.getWaterCondition().toString());

        return database.insert(DBContract.Source.TABLE_NAME, null, values);
    }

    public long addPurityReport(PurityReport purityReport) {
        ContentValues values = new ContentValues();
        values.put(DBContract.Purity.KEY_LAT, purityReport.getLocation().latitude);
        values.put(DBContract.Purity.KEY_LON, purityReport.getLocation().longitude);
        values.put(DBContract.Purity.KEY_REPORT, purityReport.getReportNumber());
        values.put(DBContract.Purity.KEY_DATE, purityReport.getDate());
        values.put(DBContract.Purity.KEY_TIME, purityReport.getTime());
        values.put(DBContract.Purity.KEY_REPORTER, purityReport.getReporter());
        values.put(DBContract.Purity.KEY_CONDITION, purityReport.getOverallCondition().toString());
        values.put(DBContract.Purity.KEY_VIRUS, purityReport.getVirusPPM());
        values.put(DBContract.Purity.KEY_CONTAMINANT, purityReport.getContaminantPPM());


        return database.insert(DBContract.Purity.TABLE_NAME, null, values);
    }

    public List<Person> getUserList() {
        List<Person> users = new ArrayList<Person>();
        String selectQuery = "SELECT * FROM " + DBContract.Users.TABLE_NAME;
        Cursor cursor = database.rawQuery(selectQuery, null);
        //System.out.println(DatabaseUtils.dumpCursorToString(cursor));
        if (cursor.moveToFirst()) {
            do {
                Person person = new Person();
                try {
                    person.setName(cursor.getString(cursor.getColumnIndex(DBContract.Users.KEY_NAME)));
                    person.setUsername(cursor.getString(cursor.getColumnIndex(DBContract.Users.KEY_USERNAME)));
                    person.setPassword(cursor.getString(cursor.getColumnIndex(DBContract.Users.KEY_PASSWORD)));
                    person.setEmail(cursor.getString(cursor.getColumnIndex(DBContract.Users.KEY_EMAIL)));
                    String type = cursor.getString(cursor.getColumnIndex(DBContract.Users.KEY_USERTYPE));
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
                    System.out.println(e);
                    return users;
                }
                users.add(person);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return users;
    }

    public void populateSources() {
        String selectQuery = "SELECT * FROM " + DBContract.Source.TABLE_NAME;
        Cursor cursor = database.rawQuery(selectQuery, null);
        Model model = Model.getInstance();
        //System.out.println(DatabaseUtils.dumpCursorToString(cursor));
        if (cursor.moveToFirst()) {
            do {
                try {
                    WaterType waterType;
                    String type = cursor.getString(cursor.getColumnIndex(DBContract.Source.KEY_TYPE));
                    switch (type) {
                        case "Bottled":
                            waterType = WaterType.BOTTLED;
                            break;
                        case "Well":
                            waterType = WaterType.WELL;
                            break;
                        case "Stream":
                            waterType = WaterType.STREAM;
                            break;
                        case "Lake":
                            waterType = WaterType.LAKE;
                            break;
                        case "Spring":
                            waterType = WaterType.SPRING;
                            break;
                        case "Other":
                            waterType = WaterType.OTHER;
                            break;
                        default:
                            waterType = WaterType.BOTTLED;
                            break;
                    }

                    WaterCondition waterCondition;
                    String condition = cursor.getString(cursor.getColumnIndex(DBContract.Source.KEY_CONDITION));
                    switch (condition) {
                        case "Waste":
                            waterCondition = WaterCondition.WASTE;
                            break;
                        case "Treatable Clear":
                            waterCondition = WaterCondition.TREATABLECLEAR;
                            break;
                        case "Treatable Muddy":
                            waterCondition = WaterCondition.TREATABLEMUDDY;
                            break;
                        case "Potable":
                            waterCondition = WaterCondition.POTABLE;
                            break;
                        default:
                            waterCondition = WaterCondition.WASTE;
                            break;
                    }

                    model.addToSources(new WaterSource(
                            cursor.getString(cursor.getColumnIndex(DBContract.Source.KEY_DATE)),
                            cursor.getString(cursor.getColumnIndex(DBContract.Source.KEY_TIME)),
                            cursor.getString(cursor.getColumnIndex(DBContract.Source.KEY_REPORTER)),
                            waterType, waterCondition,
                            Double.parseDouble(cursor.getString(cursor.getColumnIndex(DBContract.Source.KEY_LAT))),
                            Double.parseDouble(cursor.getString(cursor.getColumnIndex(DBContract.Source.KEY_LON)))
                    ));

                } catch (Exception e) {
                    System.out.println("HOUSTON WE HAVE A PROBLEM: " + e);
                    return;
                }

            } while (cursor.moveToNext());
        }
        cursor.close();
    }

    public void populatePurityReports() {
        String selectQuery = "SELECT * FROM " + DBContract.Purity.TABLE_NAME;
        Cursor cursor = database.rawQuery(selectQuery, null);
        Model model = Model.getInstance();
        //System.out.println(DatabaseUtils.dumpCursorToString(cursor));
        if (cursor.moveToFirst()) {
            do {
                try {
                    OverallCondition overallCondition;
                    String condition = cursor.getString(cursor.getColumnIndex(DBContract.Purity.KEY_CONDITION));
                    switch (condition) {
                        case "Safe":
                            overallCondition = OverallCondition.SAFE;
                            break;
                        case "Treatable":
                            overallCondition = OverallCondition.TREATABLE;
                            break;
                        case "Unsafe":
                            overallCondition = OverallCondition.UNSAFE;
                            break;
                        default:
                            overallCondition = OverallCondition.UNSAFE;
                            break;
                    }

                    model.addToPurityReports(new PurityReport(
                            cursor.getString(cursor.getColumnIndex(DBContract.Purity.KEY_DATE)),
                            cursor.getString(cursor.getColumnIndex(DBContract.Purity.KEY_TIME)),
                            cursor.getString(cursor.getColumnIndex(DBContract.Purity.KEY_REPORTER)),
                            overallCondition,
                            Double.parseDouble(cursor.getString(cursor.getColumnIndex(DBContract.Purity.KEY_VIRUS))),
                            Double.parseDouble(cursor.getString(cursor.getColumnIndex(DBContract.Purity.KEY_CONTAMINANT))),
                            new LatLng(Double.parseDouble(cursor.getString(cursor.getColumnIndex(DBContract.Source.KEY_LAT))),
                            Double.parseDouble(cursor.getString(cursor.getColumnIndex(DBContract.Source.KEY_LON))))
                    ));

                } catch (Exception e) {
                    System.out.println("HOUSTON WE HAVE A PROBLEM: " + e);
                    return;
                }

            } while (cursor.moveToNext());
        }
        cursor.close();
    }

}
