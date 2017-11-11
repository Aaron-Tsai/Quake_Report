package com.example.android.quakereport;

/**
 * Created by Aaron on 10/29/2017.
 */

public class Earthquake {
    private double mMagnitude = 0;
    private String mLocation = "Pacific Ocean";
    private long mTimeInMilliseconds = 0;
    private String mUrl = "USGS";

    public Earthquake(double magnitude, String location, long timeInMilliseconds, String url) {
        mMagnitude = magnitude;
        mLocation = location;
        mTimeInMilliseconds = timeInMilliseconds;
        mUrl = url;
    }

    public String getUrl() {return mUrl;}
    public double getMagnitude() {
        return mMagnitude;
    }
    public String getLocation(){
        return mLocation;
    }
    public long getDate() {
        return mTimeInMilliseconds;
    }

    /**
     * Returns the time of the earthquake.
     */
    public long getTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }
}
