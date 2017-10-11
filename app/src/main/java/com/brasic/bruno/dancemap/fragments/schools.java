package com.brasic.bruno.dancemap.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.brasic.bruno.dancemap.DanceSchool;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.brasic.bruno.dancemap.R;
import java.util.*;
import java.util.ArrayList;


public class schools extends Fragment {


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


                DanceSchool[] danceSchoolArray = new DanceSchool[100];

                danceSchoolArray[0] = schoolOne;

                danceSchoolArray[1] = schoolTwo ;

                danceSchoolArray[2] = schoolThree;



                DanceSchool.addMarker(googleMap,45.668993, 16.149476,"Trajektna luka","        KUČE");

                //zoom to position with level 16
                CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(position, 16);
                googleMap.animateCamera(cameraUpdate);



            }
        });
        return rootView;
    }


    DanceSchool schoolOne = new DanceSchool("School",45.714212, 16.075243,"0911922661","Salsa","SchoolOf Dance");

    DanceSchool schoolTwo = new DanceSchool("School",45.924212, 16.075243,"0911922661","Salsa","SchoolOf Dance");

    DanceSchool schoolThree = new DanceSchool("School",45.414212, 16.075243,"0911922661","Salsa","SchoolOf Dance");
/*

    DanceSchool[] danceSchoolArray = new DanceSchool[100];

    danceSchoolArray[0] = schoolOne;

    danceSchoolArray[1] = schoolTwo ;

    danceSchoolArray[2] = schoolThree;
*/

  /*  for(int i = 0;i < danceSchoolArray.size();i++){


        
    }
*/
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
/*
    private void addMarker(GoogleMap map, double lat, double lon,
                           String title, String snippet) {
        map.addMarker(new MarkerOptions().position(new LatLng(lat, lon))
                                        .title((title))
                                         .snippet((snippet)));
    }
*/
}

