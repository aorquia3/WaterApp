package com.two_six_mafia.root.waterapp.Controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.two_six_mafia.root.waterapp.Model.WaterSource;
import com.two_six_mafia.root.waterapp.R;

public class SourceViewActivity extends AppCompatActivity {

    private TextView viewReportTitle;
    private TextView viewType;
    private TextView viewCondition;
    private TextView viewDate;
    private TextView viewTime;
    private TextView viewReporter;

    private WaterSource waterSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_source_view);
        Intent intent = getIntent();
        waterSource = (WaterSource) intent.getSerializableExtra("WaterSource");

        viewReportTitle = (TextView) findViewById(R.id.viewReportTitle);
        viewType = (TextView) findViewById(R.id.viewType);
        viewCondition = (TextView) findViewById(R.id.viewCondition);
        viewDate = (TextView) findViewById(R.id.viewDate);
        viewTime = (TextView) findViewById(R.id.viewTime);
        viewReporter = (TextView) findViewById(R.id.viewReporter);

        viewReportTitle.setText("Water Source Report: " + waterSource.getSourceNumber());
        viewType.setText(waterSource.getWaterType().toString());
        viewCondition.setText(waterSource.getWaterCondition().toString());
        viewDate.setText(waterSource.getDate());
        viewTime.setText(waterSource.getTime());
        viewReporter.setText(waterSource.getReporter());

    }
}
