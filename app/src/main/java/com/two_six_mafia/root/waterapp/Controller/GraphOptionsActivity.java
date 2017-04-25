package com.two_six_mafia.root.waterapp.Controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.two_six_mafia.root.waterapp.Model.GraphType;
import com.two_six_mafia.root.waterapp.Model.WaterSource;
import com.two_six_mafia.root.waterapp.R;

import java.io.Serializable;

public class GraphOptionsActivity extends AppCompatActivity {

    private Spinner graphType;
    private EditText sourceNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historical_data);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        graphType = (Spinner) findViewById(R.id.graphType);
        sourceNumber = (EditText) findViewById(R.id.sourceNumber);
        sourceNumber.setText("-1");

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

    /**
     * Goes to the graph
     */
    private void goGraph() {
        int source =Integer.parseInt(sourceNumber.getText().toString());
        if ( source < 0 || source > WaterSource.SOURCE_COUNTER) {
            sourceNumber.setError("Please pick a valid water source.");
        } else {
            Intent intent = new Intent(this, HistoricalGraphActivity.class);
            intent.putExtra("type", (Serializable) graphType.getSelectedItem());
            intent.putExtra("source", source);
            startActivity(intent);
        }
    }
}
