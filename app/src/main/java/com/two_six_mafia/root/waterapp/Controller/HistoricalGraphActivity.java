package com.two_six_mafia.root.waterapp.Controller;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.two_six_mafia.root.waterapp.Model.GraphType;
import com.two_six_mafia.root.waterapp.Model.Model;
import com.two_six_mafia.root.waterapp.Model.WaterSource;
import com.two_six_mafia.root.waterapp.R;

public class HistoricalGraphActivity extends AppCompatActivity {

    private LineGraphSeries<DataPoint> series;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    private int dateToInt() {
        return 10;
    }

    GraphType graphType;
    int source;
    WaterSource waterSource;

    /**
     * Chooses Graph Type
     */
    private void chooseGraph() {
        if(graphType.equals(GraphType.VIRUS)) {
            graphVirus();
        } else {
            graphContaminant();
        }
    }

    /**
     * Graphs if Virus
     */
    private void graphVirus() {

    }

    /**
     * Graph if Contaminant
     */
    private void graphContaminant() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_historical_graph);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        double x,y;

        x = -5.0;
        GraphView graph = (GraphView) findViewById(R.id.graph);
        series = new LineGraphSeries<>();


        for (int i = 0; i < 500; i++) {
            x = x + .1;
            y = 5 * x;
            series.appendData(new DataPoint(x, y), true, 500);
        }
        graph.addSeries(series);

        Model model = Model.getInstance();
        graphType = (GraphType) getIntent().getSerializableExtra("type");
        source = (int) getIntent().getSerializableExtra("source");
        waterSource = model.getSourceByID(source);

    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("HistoricalGraph Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}