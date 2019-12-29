package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.content.Intent;
import android.app.PendingIntent;
import android.app.AlarmManager;
import android.widget.Toast;


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


        /*
        Intent intent = new Intent(MainActivity.this, AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this,
                0, intent, 0);
        ((AlarmManager) getSystemService(ALARM_SERVICE)).set(AlarmManager.RTC,
                System.currentTimeMillis() + 10 * 1000, pendingIntent);
        Toast.makeText(MainActivity.this, "Timer set to " + 10 + " seconds.",
                Toast.LENGTH_SHORT).show();

         */
    }

    /*public void setSpinner(Spinner spinner, int[] arr) {

    }*/

    private void OnCalculateClicked() {
        Log.d("-", "btnCalculateClicked");
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
        Log.d("-", "btnZZZClicked");
        Resources.storeToStrArr(Resources.timeZZZCalculate());
        Intent ganesh = new Intent(this, ThirdActivity.class);
        startActivity(ganesh);
    }

   /* public class AlarmReceiver extends BroadcastReceiver {
        public void onReceive(Context context, Intent intent) {
            Log.d("-", "Receiver3");
            Intent ganesh = new Intent(MainActivity.this, ThirdActivity.class);
            startActivity(ganesh);
        }
    } */

}
