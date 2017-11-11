package com.example.android.quakereport;
import android.graphics.drawable.GradientDrawable;
import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.Formatter;
import java.text.DecimalFormat;
import java.util.Date;


import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by Aaron on 10/29/2017.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {
    public EarthquakeAdapter(Activity context, int resource, ArrayList<Earthquake> earthquakeList) {
        super(context, 0, earthquakeList);
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }



        //assign currentEarthquake to the item in question. I can retrieve the item's values by calling Earthquake methods on currentEarthquake, which I do below
        Earthquake currentEarthquake = getItem(position);

        //the next lines of code are dedicated to populating a single list item with the values in currentEarthquake

        TextView magnitude = (TextView) listItemView.findViewById(R.id.magnitude);
        //Convert the retrieved double to string, so magnitude.setText will work
        String formattedMagnitude = formatMagnitude(currentEarthquake.getMagnitude());
        magnitude.setText(formattedMagnitude);

        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitude.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        //ContextCompat converts the color resource ID into a usable format for magnitudeCircle
        int magnitudeColor =  ContextCompat.getColor(getContext(), getMagnitudeColor((int)(currentEarthquake.getMagnitude())));
        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        TextView location = (TextView) listItemView.findViewById(R.id.location_offset);
        location.setText(currentEarthquake.getLocation());

        // Create a new Date object from the time in milliseconds of the earthquake
        Date dateObject = new Date(currentEarthquake.getTimeInMilliseconds());

        // Find the TextView with view ID date
        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        // Format the date string (i.e. "Mar 3, 1984")
        String formattedDate = formatDate(dateObject);
        // Display the date of the current earthquake in that TextView
        dateView.setText(formattedDate);

        // Find the TextView with view ID time
        TextView timeView = (TextView) listItemView.findViewById(R.id.time);
        // Format the time string (i.e. "4:30PM")
        String formattedTime = formatTime(dateObject);
        // Display the time of the current earthquake in that TextView
        timeView.setText(formattedTime);

        return listItemView;
    }

    private int getMagnitudeColor (int i) {
        int magnitudeColor = 0;
        switch (i) {
            case 0: magnitudeColor = R.color.magnitude1;
            case 1:
                break;
            case 2: magnitudeColor = R.color.magnitude2;
                break;
            case 3: magnitudeColor = R.color.magnitude3;
                break;
            case 4: magnitudeColor = R.color.magnitude4;
                break;
            case 5: magnitudeColor = R.color.magnitude5;
                break;
            case 6: magnitudeColor = R.color.magnitude10plus;
                break;
            case 7: magnitudeColor = R.color.magnitude1;
                break;
            case 8: magnitudeColor = R.color.magnitude8;
                break;
            case 9: magnitudeColor = R.color.magnitude9;
                break;
            case 10: magnitudeColor = R.color.magnitude10plus;
        }
        return magnitudeColor;
    }

    //method to format the magnitude
    private String formatMagnitude(double d) {
        DecimalFormat formatter = new DecimalFormat("0.00");
        String output = formatter.format(d);
        return output;
    }

    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

}
