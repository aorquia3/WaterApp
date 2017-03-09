package com.two_six_mafia.root.waterapp.Controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.two_six_mafia.root.waterapp.Model.SourceReport;
import com.two_six_mafia.root.waterapp.R;

public class SourceViewActivity extends AppCompatActivity {

    private TextView viewReportTitle;
    private TextView viewType;
    private TextView viewCondition;
    private TextView viewDate;
    private TextView viewTime;
    private TextView viewReporter;

    private SourceReport sourceReport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_source_view);
        Intent intent = getIntent();
        sourceReport = (SourceReport) intent.getSerializableExtra("SourceReport");

        viewReportTitle = (TextView) findViewById(R.id.viewReportTitle);
        viewType = (TextView) findViewById(R.id.viewType);
        viewCondition = (TextView) findViewById(R.id.viewCondition);
        viewDate = (TextView) findViewById(R.id.viewDate);
        viewTime = (TextView) findViewById(R.id.viewTime);
        viewReporter = (TextView) findViewById(R.id.viewReporter);

        viewReportTitle.setText("Water Source Report: " + sourceReport.getReportNumber());
        viewType.setText(sourceReport.getWaterType().toString());
        viewCondition.setText(sourceReport.getWaterCondition().toString());
        viewDate.setText(sourceReport.getDate());
        viewTime.setText(sourceReport.getTime());
        viewReporter.setText(sourceReport.getReporter());

    }
}
