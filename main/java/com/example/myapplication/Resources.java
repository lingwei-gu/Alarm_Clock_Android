package com.example.myapplication;

import android.widget.RelativeLayout;

import java.util.Calendar;
import java.util.Date;

public class Resources {


    public static String[] timeSlot = new String[4];

    public static int[] timeZZZCalculate() {
        Date date= new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        String currentTimeAll = Calendar.getInstance().getTime().toString();
        String currentTime = currentTimeAll.split(" ")[3];
        int[] time = {Integer.parseInt(currentTime.split(":")[0]), //hour
                Integer.parseInt(currentTime.split(":")[1]), //minutes
                cal.get(Calendar.YEAR), //year
                cal.get(Calendar.MONTH), //month
                cal.get(Calendar.DATE), //date
        };
        return time;
    }

    public static void storeToStrArr(int[] time){
        time[1] = time[1] + 14; // 14 mins to fall asleep

        // 0 -> 3 cycles -> 4.5 hours
        // 1 -> 4 cycles -> 6 hours
        // 2 -> 5 cycles -> 7.5 hours
        // 3 -> 6 cycles -> 9 hours
        int[] time_24 = new int[2];

        for (int i = 0; i < 4; i++) {
            time_24[0] = time[0];
            time_24[1] = time[1];
            if(i == 0){
                time_24[0] += 4;
                time_24[1] += 30;
            } else if(i == 1){
                time_24[0] += 5;
            } else if(i == 2){
                time_24[0] += 7;
                time_24[1] += 30;
            } else {
                time_24[0] += 9;
            }

            if(time_24[1] >= 60){
                time_24[0] += 1;
                time_24[1] -= 60;
            }

            if(time_24[0] >= 24) {
                time_24[0] += 1;
                time_24[1] -= 24;
            }

            Resources.timeSlot[i] = standard2Strings(time_24);
        }
    }

    public static String standard2Strings(int[] time) {
        String h = ""+ time[0];
        String m = ""+ time[1];
        if(time[0] < 10)
            h = "0" + h;
        if(time[1] < 10)
            m = "0" + m;
        return (h + " : " + m);
    }

}
