package com.two_six_mafia.root.waterapp.Controller;

import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.two_six_mafia.root.waterapp.R;

import java.util.Locale;

public class SourceReportActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_source_report);

        EditText autoDate = (EditText)findViewById(R.id.autoDate);
        EditText autoTime = (EditText)findViewById(R.id.autoTime);

        SimpleDateFormat dateFormat = new SimpleDateFormat("d MMM yyyy", Locale.getDefault());
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());

        String date = dateFormat.format(Calendar.getInstance().getTime());
        String time = timeFormat.format(Calendar.getInstance().getTime());

        autoDate.setText(date);
        autoTime.setText(time);
    }
}
