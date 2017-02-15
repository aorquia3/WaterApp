package com.two_six_mafia.root.waterapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

public class WelcomeActivity extends AppCompatActivity {

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
    }

    /**
     * Sets the login button to go to the log in page.
     */
    private void goLogin() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    /**
     * Sets the register button to go to the register page.
     */
    private void goRegister() {
        Intent intent = new Intent(this, RegistrationActivity.class);
        startActivity(intent);
        finish();
    }

}
