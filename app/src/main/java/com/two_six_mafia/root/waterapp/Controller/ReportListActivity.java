package com.two_six_mafia.root.waterapp.Controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.two_six_mafia.root.waterapp.Model.Model;
import com.two_six_mafia.root.waterapp.Model.WaterSource;
import com.two_six_mafia.root.waterapp.R;

import java.util.ArrayList;
import java.util.List;

public class ReportListActivity extends AppCompatActivity {

    private ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_list);

        listview = (ListView) findViewById(R.id.reportList);

        Model model = Model.getInstance();
        List<WaterSource> waterReports = (ArrayList) model.getSourceList();

        ArrayAdapter<WaterSource> arrayAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, waterReports);
        listview.setAdapter(arrayAdapter);

    }
}
