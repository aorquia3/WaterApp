package com.two_six_mafia.root.waterapp.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

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
        values.put(DBContract.Users.KEY_USERNAME, person.getUsername().toString());
        values.put(DBContract.Users.KEY_EMAIL, person.getEmail().toString());
        values.put(DBContract.Users.KEY_PASSWORD, person.getPassword().toString());
        values.put(DBContract.Users.KEY_USERTYPE, person.getUserType().toString());

        return database.insert(DBContract.Users.TABLE_NAME, null, values);
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
}
