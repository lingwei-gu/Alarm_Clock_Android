package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Spinner hour_spinner = (Spinner) findViewById(R.id.hours_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> hour_adapter = ArrayAdapter.createFromResource(this,
                R.array.h_arr, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        hour_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        hour_spinner.setAdapter(hour_adapter);


        Spinner min_spinner = (Spinner) findViewById(R.id.min_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> min_adapter = ArrayAdapter.createFromResource(this,
                R.array.min_arr, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        min_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        min_spinner.setAdapter(min_adapter);


        Spinner spinner = (Spinner) findViewById(R.id.am_pm_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> am_pm_adapter = ArrayAdapter.createFromResource(this,
                R.array.am_pm_arr, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        am_pm_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(am_pm_adapter);
    }
    public void setSpinner(Spinner spinner, int[] arr){

    }

}
