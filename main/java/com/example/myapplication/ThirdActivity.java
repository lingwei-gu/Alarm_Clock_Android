package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import java.lang.String;

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

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OnButton1Clicked();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OnButton2Clicked();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OnButton3Clicked();
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OnButton4Clicked();
            }
        });
    }

    private void OnButton1Clicked() {
        Log.d("-", "button1Clicked");
        setAlarm(timeSlotToInt(Resources.timeSlot[0])[0],timeSlotToInt(Resources.timeSlot[0])[1]);
    }

    private void OnButton2Clicked() {
        Log.d("-", "button2Clicked");
        setAlarm(timeSlotToInt(Resources.timeSlot[1])[0],timeSlotToInt(Resources.timeSlot[1])[1]);
    }

    private void OnButton3Clicked() {
        Log.d("-", "button3Clicked");
        setAlarm(timeSlotToInt(Resources.timeSlot[2])[0],timeSlotToInt(Resources.timeSlot[2])[1]);
    }

    private void OnButton4Clicked() {
        Log.d("-", "button4Clicked");
        setAlarm(timeSlotToInt(Resources.timeSlot[3])[0],timeSlotToInt(Resources.timeSlot[3])[1]);
    }

    public int[] timeSlotToInt(String timeSlot) {
        int intTime[] = new int[2];
        if(timeSlot.split(" : ")[0].startsWith("00")) {
            intTime[0] = 0;
        } else if(timeSlot.split(" : ")[0].charAt(0) == '0') {
            intTime[0] = timeSlot.split(" : ")[0].charAt(1);
        } else {
            intTime[0] = Integer.parseInt(timeSlot.split(" : ")[0]);
        }

        if(timeSlot.split(" : ")[1] == "00") {
            intTime[1] = 0;
        } else if(timeSlot.split(" : ")[1].charAt(0) == '0') {
            intTime[1] = timeSlot.split(" : ")[1].charAt(1);
        } else {
            intTime[1] = Integer.parseInt(timeSlot.split(" : ")[1]);
        }
        return intTime;
    }

    public void setAlarm(int hour, int minute) {
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
        intent.putExtra(AlarmClock.EXTRA_HOUR, hour);
        intent.putExtra(AlarmClock.EXTRA_MINUTES, minute);
        startActivity(intent);
    }

}