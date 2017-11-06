package com.example.android.quakereport;

/**
 * Created by Aaron on 10/29/2017.
 */

public class Earthquake {
    private double magnitude = 0;
    private String location = "Pacific Ocean";
    private long date = 0;


    public Earthquake(double m, String l, long d ) {
        magnitude = m;
        location = l;
        date = d;

    }

    public double getMagnitude() {
        return magnitude;
    }
    public String getLocation(){
        return location;
    }
    public long getDate() {
        return date;
    }

}
