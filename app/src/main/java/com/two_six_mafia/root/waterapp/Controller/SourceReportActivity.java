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
import android.widget.Toast;

import com.google.android.gms.common.api.GoogleApiClient;
import com.two_six_mafia.root.waterapp.Model.Database;
import com.two_six_mafia.root.waterapp.Model.Model;
import com.two_six_mafia.root.waterapp.Model.WaterCondition;
import com.two_six_mafia.root.waterapp.Model.WaterSource;
import com.two_six_mafia.root.waterapp.Model.WaterType;
import com.two_six_mafia.root.waterapp.R;

import java.util.Locale;

public class SourceReportActivity extends AppCompatActivity {

    private Spinner waterType;
    private Spinner waterCondition;
    private EditText date;
    private EditText time;
    private EditText latitude;
    private EditText longitude;
    private Button add;
    private Button cancel;

    private final Double DEFAULT_LAT = -34.0;
    private final Double DEFAULT_LON = 151.0;

    private Database database;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_source_report);

        //Lots of buttons and spinners
        waterType = (Spinner) findViewById(R.id.waterType);
        waterCondition = (Spinner) findViewById(R.id.waterCondition);
        latitude = (EditText) findViewById(R.id.latitude);
        longitude = (EditText) findViewById(R.id.longitude);
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

        //Populate date and time fields.
        EditText autoDate = (EditText) findViewById(R.id.autoDate);
        EditText autoTime = (EditText) findViewById(R.id.autoTime);

        SimpleDateFormat dateFormat = new SimpleDateFormat("d MMM yyyy", Locale.getDefault());
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());

        String date = dateFormat.format(Calendar.getInstance().getTime());
        String time = timeFormat.format(Calendar.getInstance().getTime());

        autoDate.setText(date);
        autoTime.setText(time);

        latitude.setText(DEFAULT_LAT.toString());
        longitude.setText(DEFAULT_LON.toString());

        //Set spinners for the watertype and watercondition spinners.
        ArrayAdapter<WaterType> adapter1 = new ArrayAdapter(this,android.R.layout.simple_spinner_item, WaterType.values());
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        waterType.setAdapter(adapter1);

        ArrayAdapter<WaterCondition> adapter2 = new ArrayAdapter(this,android.R.layout.simple_spinner_item, WaterCondition.values());
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        waterCondition.setAdapter(adapter2);

        database = new Database(this);
    }

    /**
     * Adds to the model
     */
    private void add() {
        Model model = Model.getInstance();

        WaterSource waterSource = new WaterSource(date.getText().toString(), time.getText().toString(),
                model.getCurrentUser().getName(), (WaterType) waterType.getSelectedItem(),
                (WaterCondition) waterCondition.getSelectedItem(),
                Double.parseDouble(latitude.getText().toString()), Double.parseDouble(longitude.getText().toString()));
        model.addToSources(waterSource);

        long row  = database.addSource(waterSource);
        Toast.makeText(this, "New Source added to database at row "
                + row, Toast.LENGTH_LONG).show();
        cancel();
    }

    /**
     * This will cancel and return to the homescreen.
     */
    private void cancel() {
        Intent intent = new Intent(this, HomescreenActivity.class);
        startActivity(intent);
        finish();
    }

}
