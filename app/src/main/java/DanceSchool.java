package com.brasic.bruno.dancemap;


import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by bruno on 20.09.17..
 */

public class DanceSchool {

    String name;
    LatLng position;
    double lat;
    double lon;
    String phoneNumber;
    String typesOfDance;
    String snippet;


    public DanceSchool(String name, double lat, double lon, String phoneNumber, String typesOfDance,String snippet){
        this.name = name;
        this.lat = lat;
        this.lon = lon;
        this.position = position;
        this.phoneNumber = phoneNumber;
        this.typesOfDance = typesOfDance;
        this.snippet = snippet;
    }

    public static void addMarker(GoogleMap map, double lat, double lon, String name, String snippet) {
        map.addMarker(new MarkerOptions().position(new LatLng(lat, lon))
                .title((name))
                .snippet((snippet)));
    }

    }



