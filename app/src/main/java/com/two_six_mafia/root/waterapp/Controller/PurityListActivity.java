package com.two_six_mafia.root.waterapp.Controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.two_six_mafia.root.waterapp.Model.Model;
import com.two_six_mafia.root.waterapp.Model.PurityReport;
import com.two_six_mafia.root.waterapp.R;

import java.util.List;

public class PurityListActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purity_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listView = (ListView) findViewById(R.id.purityListView);

        Model model = Model.getInstance();
        List<PurityReport> purityReports = model.getPurityReports();

        ArrayAdapter<PurityReport> arrayAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_expandable_list_item_1, purityReports);
        listView.setAdapter(arrayAdapter);


    }
}
