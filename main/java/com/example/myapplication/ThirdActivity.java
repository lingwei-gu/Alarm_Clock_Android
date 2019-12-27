package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;


public class ThirdActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_activity);

        Button button1 = (Button)findViewById(R.id.zzz_button1);
        button1.setText(Resources.timeSlot[0]);

        Button button2 = (Button)findViewById(R.id.zzz_button2);
        button2.setText(Resources.timeSlot[1]);

        Button button3 = (Button)findViewById(R.id.zzz_button3);
        button3.setText(Resources.timeSlot[2]);

        Button button4 = (Button)findViewById(R.id.zzz_button4);
        button4.setText(Resources.timeSlot[3]);
    }
}
