package com.example.android.quakereport;

/**
 * Created by Aaron on 10/29/2017.
 */

public class Earthquake {
    private double mMagnitude = 0;
    private String mLocation = "Pacific Ocean";
    private long mTimeInMilliseconds = 0;

    public Earthquake(double magnitude, String location, long timeInMilliseconds) {
        mMagnitude = magnitude;
        mLocation = location;
        mTimeInMilliseconds = timeInMilliseconds;
    }

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
