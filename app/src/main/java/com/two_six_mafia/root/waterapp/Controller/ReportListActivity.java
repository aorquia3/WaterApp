package com.two_six_mafia.root.waterapp.Controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.two_six_mafia.root.waterapp.Model.Model;
import com.two_six_mafia.root.waterapp.Model.SourceReport;
import com.two_six_mafia.root.waterapp.Model.WaterSource;
import com.two_six_mafia.root.waterapp.R;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ReportListActivity extends AppCompatActivity {

    private ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_list);

        listview = (ListView) findViewById(R.id.reportList);

        Model model = Model.getInstance();
        List<SourceReport> sourceReports = (ArrayList) model.getReportList();
        List<String> testlist = new ArrayList<>();

        //I feel like this should not be necessary.
        for(SourceReport report : sourceReports) {
            testlist.add(report.toString());
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, testlist);
        listview.setAdapter(arrayAdapter);

    }
}
