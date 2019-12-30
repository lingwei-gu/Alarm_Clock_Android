package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.content.Intent;



public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Spinner hour_spinner = (Spinner) findViewById(R.id.hours_spinner);
       // hour_spinner.setBackgroundColor(Color.parseColor("#0B1F3F"));
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> hour_adapter = ArrayAdapter.createFromResource(this,
                R.array.h_arr, R.layout.spinner_item);
        // Specify the layout to use when the list of choices appears
        hour_adapter.setDropDownViewResource(R.layout.spinner_item);
        // Apply the adapter to the spinner
        hour_spinner.setAdapter(hour_adapter);


        Spinner min_spinner = (Spinner) findViewById(R.id.min_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> min_adapter = ArrayAdapter.createFromResource(this,
                R.array.min_arr, R.layout.spinner_item);
        // Specify the layout to use when the list of choices appears
        min_adapter.setDropDownViewResource(R.layout.spinner_item);
        // Apply the adapter to the spinner
        min_spinner.setAdapter(min_adapter);


        Spinner am_pm_spinner = (Spinner) findViewById(R.id.am_pm_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> am_pm_adapter = ArrayAdapter.createFromResource(this,
                R.array.am_pm_arr, R.layout.spinner_item);
        // Specify the layout to use when the list of choices appears
        am_pm_adapter.setDropDownViewResource(R.layout.spinner_item);
        // Apply the adapter to the spinner
        am_pm_spinner.setAdapter(am_pm_adapter);


        Button btnCalculate = (Button) findViewById(R.id.calc_button);
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OnCalculateClicked();
            }
        });

        Button btnZZZ = (Button) findViewById(R.id.button3);
        btnZZZ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OnZZZClicked();
            }
        });

    }

    /*public void setSpinner(Spinner spinner, int[] arr) {

    }*/

    private void OnCalculateClicked() {
        //Log.d("-", "btnCalculateClicked");
        // do something here
        Spinner hour_spinner = (Spinner) findViewById(R.id.hours_spinner);
        Spinner min_spinner = (Spinner) findViewById(R.id.min_spinner);
        Spinner am_pm_spinner = (Spinner) findViewById(R.id.am_pm_spinner);
        int[] timeArr = Resources.takeInput(hour_spinner,min_spinner,am_pm_spinner);
        Resources.storeToStrArrBackwards(timeArr);
        Intent ganesh = new Intent(this, SecondActivity.class);
        startActivity(ganesh);
    }

    private void OnZZZClicked() {
        //Log.d("-", "btnZZZClicked");
        Resources.storeToStrArr(Resources.timeZZZCalculate());
        Intent ganesh = new Intent(this, ThirdActivity.class);
        startActivity(ganesh);
    }


}