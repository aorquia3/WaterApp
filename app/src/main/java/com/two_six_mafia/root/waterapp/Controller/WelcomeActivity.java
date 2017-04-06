package com.two_six_mafia.root.waterapp.Controller;

import android.content.Intent;
/*
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
*/
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

import com.two_six_mafia.root.waterapp.Controller.LoginActivity;
import com.two_six_mafia.root.waterapp.Controller.RegistrationActivity;
import com.two_six_mafia.root.waterapp.Model.DBContract;
import com.two_six_mafia.root.waterapp.Model.DBHelper;
import com.two_six_mafia.root.waterapp.Model.Database;
import com.two_six_mafia.root.waterapp.Model.Person;
import com.two_six_mafia.root.waterapp.Model.User;
import com.two_six_mafia.root.waterapp.Model.UserList;
import com.two_six_mafia.root.waterapp.Model.UserType;

import com.two_six_mafia.root.waterapp.R;

import java.util.List;

public class WelcomeActivity extends AppCompatActivity {
    private Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Water App");

        Button login = (Button) findViewById(R.id.welcome_login);
        login.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                goLogin();
            }
        });

        Button register = (Button) findViewById(R.id.welcome_register);
        register.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                goRegister();
            }
        });

        database = new Database(this);
        UserList userList = UserList.getInstance();
        List<Person> users = database.getUserList();
        users.add(new Person("natz", "deez", "my name", "urface@gatech.com", UserType.USER));
        for (Person person : users) {
            userList.addUser(person);
        }

        database.populateSources();
        database.populatePurityReports();

    }

    /**
     * Sets the login button to go to the log in page.
     */
    private void goLogin() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    /**
     * Sets the register button to go to the register page.
     */
    private void goRegister() {
        Intent intent = new Intent(this, RegistrationActivity.class);
        startActivity(intent);
    }

}
