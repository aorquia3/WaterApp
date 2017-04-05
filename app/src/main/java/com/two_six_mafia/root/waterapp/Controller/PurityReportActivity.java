package com.two_six_mafia.root.waterapp.Controller;

import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.android.gms.maps.model.LatLng;
import com.two_six_mafia.root.waterapp.Model.Model;
import com.two_six_mafia.root.waterapp.Model.OverallCondition;
import com.two_six_mafia.root.waterapp.Model.PurityReport;
import com.two_six_mafia.root.waterapp.R;

import java.util.Locale;

public class PurityReportActivity extends AppCompatActivity {

    private Spinner overallCondition;
    private EditText virusPPM;
    private EditText contaminantPPM;
    private EditText latitude;
    private EditText longitude;
    private Button addPurityReport;
    private Button cancelPurityReport;

    private Double DEFAULT_LAT = -34.0;
    private Double DEFAULT_LON = 151.0;

    private String date;
    private String time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purity_report);

        overallCondition = (Spinner)  findViewById(R.id.overallConditionSpinner);
        virusPPM = (EditText) findViewById(R.id.virusPPM);
        contaminantPPM = (EditText) findViewById(R.id.contaminantPPM);
        latitude = (EditText) findViewById(R.id.purityLatitude);
        longitude = (EditText) findViewById(R.id.purityLongitude);
        addPurityReport = (Button) findViewById(R.id.addPurityReport);
        cancelPurityReport = (Button) findViewById(R.id.cancelPurityReport);

        addPurityReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add();
            }
        });
        cancelPurityReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancel();
            }
        });

        SimpleDateFormat dateFormat = new SimpleDateFormat("d MMM yyyy", Locale.getDefault());
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());

        date = dateFormat.format(Calendar.getInstance().getTime());
        time = timeFormat.format(Calendar.getInstance().getTime());

        //Populate the spinner.
        ArrayAdapter<OverallCondition> adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,OverallCondition.values());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        overallCondition.setAdapter(adapter);

        //Set dummy location defaults
        latitude.setText(DEFAULT_LAT.toString());
        longitude.setText(DEFAULT_LON.toString());
        //virusPPM.setText(String.valueOf(0.0));
        //contaminantPPM.setText(String.valueOf(0.0));
    }

    /**
     * Adds the purity report to the model
     */
    private void add() {
        Model model = Model.getInstance();
        if (virusPPM.getText().toString().equals("")) {
            virusPPM.setError("Please enter virus PPM.");
            return;
            //virusPPM.setText(String.valueOf(0.0));
        }
        if (contaminantPPM.getText().toString().equals("")) {
            contaminantPPM.setError("Please enter contaminant PPM.");
            return;
            //contaminantPPM.setText(String.valueOf(0.0));
        }
        if (latitude.getText().toString().equals("")) {
            latitude.setError("Please enter a latitude");
            return;
        }
        if (longitude.getText().toString().equals("")) {
            longitude.setError("Please enter a longitude");
            return;
        }

    PurityReport purityReport = new PurityReport(date, time, model.getCurrentUser().getName(),
            (OverallCondition) overallCondition.getSelectedItem(),
            Double.parseDouble(virusPPM.getText().toString()),
            Double.parseDouble(contaminantPPM.getText().toString()),
            new LatLng(Double.parseDouble(latitude.getText().toString()), Double.parseDouble(
                    longitude.getText().toString())));

        model.addToPurityReports(purityReport);
    cancel();
}

    /**
     * Cancels the report
     */
    private void cancel() {
        Intent intent = new Intent(this, HomescreenActivity.class);
        startActivity(intent);
        finish();
    }
}
