package com.two_six_mafia.root.waterapp.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.two_six_mafia.root.waterapp.Model.Manager;
import com.two_six_mafia.root.waterapp.Model.Model;
import com.two_six_mafia.root.waterapp.Model.PurityReport;
import com.two_six_mafia.root.waterapp.Model.Worker;
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

        Button createPurityReport = (Button) findViewById(R.id.createPurityReport);
        createPurityReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createPurityReport();
            }
        });

        Button viewReports = (Button) findViewById(R.id.viewReports);
        viewReports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewReports();
            }
        });

        Button viewMap = (Button) findViewById(R.id.viewMap);
        viewMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewMap();
            }
        });

        Button viewPurityReports = (Button) findViewById(R.id.viewPurityReports);
        viewPurityReports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPurityReports();
            }
        });

        Model model = Model.getInstance();

        //Only lets certain user types access features.
        createPurityReport.setClickable(false);
        createPurityReport.setEnabled(false);
        viewPurityReports.setClickable(false);
        viewPurityReports.setEnabled(false);

        if(model.getCurrentUser() instanceof Worker) {
            createPurityReport.setClickable(true);
            createPurityReport.setEnabled(true);
        }

        if (model.getCurrentUser() instanceof Manager) {
            createPurityReport.setClickable(true);
            createPurityReport.setEnabled(true);
            viewPurityReports.setClickable(true);
            viewPurityReports.setEnabled(true);
        }

    }

    /**
     * Sets logout button to go to welcome page
     */
    private void logout() {
        Intent intent = new Intent(this, WelcomeActivity.class);
        Model model = Model.getInstance();
        model.removeCurrentUser();
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

    /**
     * Takes you to the purity report screen.
     */
    private void createPurityReport() {
        Intent intent = new Intent(this, PurityReportActivity.class);
        startActivity(intent);
    }

    /**
     * Views the Reports
     */
    private void viewReports() {
        Intent intent = new Intent(this, ReportListActivity.class);
        startActivity(intent);
    }

    /**
     * Views the purity reports
     */
    private void viewPurityReports() {
        Intent intent = new Intent(this, PurityListActivity.class);
        startActivity(intent);
    }

    /**
     * Views the map
     */
    private void viewMap() {
        Intent intent = new Intent(this, WaterAvailibilityActivity.class);
        startActivity(intent);
    }

}
