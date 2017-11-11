/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.quakereport;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class EarthquakeActivity extends AppCompatActivity {
    private int magnitude;
    public static final String LOG_TAG = EarthquakeActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);

        // Create a fake list of earthquakes.
        //declare the arraylist final so we can set an item click listener on it
        final ArrayList<Earthquake> earthquakes = QueryUtils.extractEarthquakes();

        // Find a reference to the {@link ListView} in the layout
        ListView earthquakeListView = (ListView) findViewById(R.id.list);

        // Create a new {@link ArrayAdapter} of earthquakes
        EarthquakeAdapter adapter = new EarthquakeAdapter(
                this, R.layout.list_item, earthquakes);

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        earthquakeListView.setAdapter(adapter);

        //attaching an onItemClickListener to the listview in order to send url intent
        //(new AdapterView.OnItemClickListener) is the anonymous inner class and onItemClick() is the corresponding overridden method
        earthquakeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //we want this method to send an intent that opens the url in a browser
                //create variable currentEarthquake representing the item we're currently on in the listview
                Earthquake currentEarthquake = earthquakes.get(position);
                //create the intent object
                Intent i = new Intent(Intent.ACTION_VIEW);
                //attach the current Earthquake item's url to the intent
                i.setData(Uri.parse(currentEarthquake.getUrl()));
                //execute
                startActivity(i);
            }
        });
    }
}
