package com.brasic.bruno.dancemap.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.brasic.bruno.dancemap.R;


public class parties extends Fragment {


    MapView mapView;
    LatLng position = new LatLng(37.77493, -122.41942);
    String markerText = "San Fransisco";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.map, container, false);

        //initialize map
        mapView = rootView.findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(new OnMapReadyCallback( ) {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                Log.i("DEBUG", "onMapReady");

                //add marker
                Marker marker  = googleMap.addMarker(new MarkerOptions().position(position).title(markerText));

                //zoom to position with level 16
                CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(position, 16);
                googleMap.animateCamera(cameraUpdate);
            }
        });
        return rootView;
    }

    @Override
    public void onResume() {
        mapView.onResume();
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }
}
