package com.example.android.quakereport;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

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
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Earthquake currentEarthquake = getItem(position);

        TextView magnitude = (TextView) listItemView.findViewById(R.id.magnitude);
        //Convert the retrieved double to string, so magnitude.setText will work
        String stringDouble= Double.toString(currentEarthquake.getMagnitude());
        magnitude.setText(stringDouble);

        TextView location = (TextView) listItemView.findViewById(R.id.location);
        location.setText(currentEarthquake.getLocation());

        TextView date = (TextView) listItemView.findViewById(R.id.date);
        //Convert the retrieved long to string, so date.setText will work
        String stringLong= Long.toString(currentEarthquake.getDate());
        date.setText(stringLong);

        return listItemView;
    }
}
