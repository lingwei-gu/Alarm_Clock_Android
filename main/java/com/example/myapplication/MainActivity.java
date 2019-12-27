package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
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
import java.util.Calendar;
import java.util.Date;


public class MainActivity extends AppCompatActivity {
    public static String[] timeSlot = new String[4];
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


        Button btnCalculate = (Button) findViewById(R.id.calc_button);
        btnCalculate.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                OnCalculateClicked();
            }
        });

        Button btnZZZ = (Button) findViewById(R.id.button3);
        btnZZZ.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                OnZZZClicked();
            }
        });


        Intent intent = new Intent(MainActivity.this, AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this,
                0, intent, 0);
        ((AlarmManager) getSystemService(ALARM_SERVICE)).set(AlarmManager.RTC,
                System.currentTimeMillis() + 10 * 1000, pendingIntent);
        Toast.makeText(MainActivity.this, "Timer set to " + 10 + " seconds.",
                Toast.LENGTH_SHORT).show();
    }
    public void setSpinner(Spinner spinner, int[] arr){

    }

    private void OnCalculateClicked()
    {
        Log.d("-","btnCalculateClicked");
        Intent ganesh = new Intent(this, SecondActivity.class);
        startActivity(ganesh);
    }

    private void OnZZZClicked()
    {
        Log.d("-","btnZZZClicked");
        Intent ganesh = new Intent(this, SecondActivity.class);
        startActivity(ganesh);

    }

    public void timeZZZCalculate() {
        Date currentTime = Calendar.getInstance().getTime();
        currentTime = currentTime.split();
    }

    public static class AlarmReceiver extends BroadcastReceiver {
        public void onReceive(Context context, Intent intent) {
            Log.d("-", "Receiver3");
        }
    }
}
