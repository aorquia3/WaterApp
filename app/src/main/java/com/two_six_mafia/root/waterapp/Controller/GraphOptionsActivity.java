package com.two_six_mafia.root.waterapp.Controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.two_six_mafia.root.waterapp.Model.GraphType;
import com.two_six_mafia.root.waterapp.R;

import java.io.Serializable;

public class GraphOptionsActivity extends AppCompatActivity {

    private Spinner graphType;
    private EditText sourceNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historical_data);

        graphType = (Spinner) findViewById(R.id.graphType);
        sourceNumber = (EditText) findViewById(R.id.sourceNumber);

        ArrayAdapter<GraphType> adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, GraphType.values());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        graphType.setAdapter(adapter);

        Button graph = (Button) findViewById(R.id.GoToGraph);
        graph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goGraph();
            }
        });
    }

    private void goGraph() {
        Intent intent = new Intent(this, HistoricalGraphActivity.class);
        intent.putExtra("type", (Serializable) graphType.getSelectedItem());
        startActivity(intent);
    }
}
