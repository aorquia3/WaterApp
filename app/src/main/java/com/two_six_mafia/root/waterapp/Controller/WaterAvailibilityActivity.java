package com.two_six_mafia.root.waterapp.Controller;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import com.two_six_mafia.root.waterapp.Model.Model;
import com.two_six_mafia.root.waterapp.Model.WaterSource;
import com.two_six_mafia.root.waterapp.R;

public class WaterAvailibilityActivity extends FragmentActivity implements GoogleMap.OnInfoWindowClickListener, OnMapReadyCallback {

    private GoogleMap mMap;
    private Marker marker;
    private WaterSource waterSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_availibility);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setOnInfoWindowClickListener(this);
        Model model = Model.getInstance();
        for (WaterSource source : model.getSourceList()) {
            marker = mMap.addMarker(new MarkerOptions().position(source.getLocation())
                    .title("Source " + source.getSourceNumber())
                    .snippet("Water Type: " + source.getWaterType()
                            + ", Latest Water Condition: " + source.getWaterCondition()));
            marker.setTag(source);
            mMap.moveCamera(CameraUpdateFactory.newLatLng(source.getLocation()));
        }
    }

    @Override
    public void onInfoWindowClick(Marker marker) {
        Intent intent = new Intent(this, SourceViewActivity.class);
        waterSource = (WaterSource) marker.getTag();
        intent.putExtra("WaterSource", waterSource);
        startActivity(intent);
    }
}
