package com.two_six_mafia.root.waterapp.Controller;

import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.two_six_mafia.root.waterapp.Model.Model;
import com.two_six_mafia.root.waterapp.Model.SourceReport;
import com.two_six_mafia.root.waterapp.Model.UserType;
import com.two_six_mafia.root.waterapp.Model.WaterCondition;
import com.two_six_mafia.root.waterapp.Model.WaterSource;
import com.two_six_mafia.root.waterapp.Model.WaterType;
import com.two_six_mafia.root.waterapp.R;

import java.util.Locale;

public class SourceReportActivity extends AppCompatActivity {

    private Spinner waterType;
    private Spinner waterCondition;
    private EditText userName;
    private EditText sourceLocation;
    private EditText date;
    private EditText time;
    private Button add;
    private Button cancel;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_source_report);

        waterType = (Spinner) findViewById(R.id.waterType);
        waterCondition = (Spinner) findViewById(R.id.waterCondition);
        userName = (EditText) findViewById(R.id.userName);
        sourceLocation = (EditText) findViewById(R.id.sourceLocation);
        date = (EditText) findViewById(R.id.autoDate);
        time = (EditText) findViewById(R.id.autoTime);
        add = (Button) findViewById(R.id.addSourceReport);
        cancel = (Button) findViewById(R.id.cancelSourceReport);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancel();
            }
        });

        EditText autoDate = (EditText) findViewById(R.id.autoDate);
        EditText autoTime = (EditText) findViewById(R.id.autoTime);

        SimpleDateFormat dateFormat = new SimpleDateFormat("d MMM yyyy", Locale.getDefault());
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());

        String date = dateFormat.format(Calendar.getInstance().getTime());
        String time = timeFormat.format(Calendar.getInstance().getTime());

        autoDate.setText(date);
        autoTime.setText(time);

        ArrayAdapter<String> adapter1 = new ArrayAdapter(this,android.R.layout.simple_spinner_item, WaterType.values());
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        waterType.setAdapter(adapter1);

        ArrayAdapter<String> adapter2 = new ArrayAdapter(this,android.R.layout.simple_spinner_item, WaterCondition.values());
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        waterCondition.setAdapter(adapter2);

    }

    private void add() {
        Model model = Model.getInstance();
        //Still need to validate user inputs before creating the object.
        SourceReport sourceReport = new SourceReport(date.getText().toString(), time.getText().toString(),
                userName.getText().toString(), (WaterType) waterType.getSelectedItem(),
                (WaterCondition) waterCondition.getSelectedItem());
        model.addToReports(sourceReport);

        WaterSource waterSource = new WaterSource(sourceReport);
        waterSource.setLocation(Integer.parseInt(sourceLocation.getText().toString()));
        model.addToSources(waterSource);
        cancel();
    }

    private void cancel() {
        Intent intent = new Intent(this, HomescreenActivity.class);
        startActivity(intent);
    }

}
