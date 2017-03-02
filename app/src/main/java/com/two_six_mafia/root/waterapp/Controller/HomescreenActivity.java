package com.two_six_mafia.root.waterapp.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.two_six_mafia.root.waterapp.R;

public class HomescreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button logout = (Button) findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logout();
            }
        });

        Button editUser = (Button) findViewById(R.id.editUser);
        editUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editProfile();
            }
        });

        Button source_report = (Button) findViewById(R.id.source_report);
        source_report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sourceReport();
            }
        });
    }

    /**
     * Sets logout button to go to welcome page
     */
    private void logout() {
        Intent intent = new Intent(this, WelcomeActivity.class);
        startActivity(intent);
        finish();
    }

    /**
     * Takes the user to the Edit Profile Page
     */
    private void editProfile() {
        Intent intent = new Intent(this, EditProfileActivity.class);
        startActivity(intent);
    }

    /**
     * Takes the user to create a new source report on SourceReport
     */
    private void sourceReport() {
        Intent intent = new Intent(this, SourceReportActivity.class);
        startActivity(intent);
    }

}
