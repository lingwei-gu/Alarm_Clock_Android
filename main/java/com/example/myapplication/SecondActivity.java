package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        Button button1 = (Button)findViewById(R.id.calc_button1);
        button1.setText(Resources.timeSlotBackwards[0]);

        Button button2 = (Button)findViewById(R.id.calc_button2);
        button2.setText(Resources.timeSlotBackwards[1]);

        Button button3 = (Button)findViewById(R.id.calc_button3);
        button3.setText(Resources.timeSlotBackwards[2]);

        Button button4 = (Button)findViewById(R.id.calc_button4);
        button4.setText(Resources.timeSlotBackwards[3]);
    }
}
