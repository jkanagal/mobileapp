package com.example.myapplication_smartblinds;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.widget.EditText;

import com.google.android.material.switchmaterial.SwitchMaterial;

import java.text.SimpleDateFormat;

public class schedule_page extends AppCompatActivity{
    private SwitchMaterial toggle;
    private EditText editFromTime;
    private EditText editToTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_page);

        editFromTime = (EditText) findViewById(R.id.editFromTime);
        editToTime = (EditText) findViewById(R.id.editToTime);

        toggle = (SwitchMaterial) findViewById(R.id.scheduleToggle);
        toggle.setOnCheckedChangeListener((buttonView, isChecked) -> {
            Log.v("Switch State", ""+isChecked);
                scheduler(isChecked);
        });

    }

    private void scheduler(boolean isChecked) {
            if(!isChecked){
                Log.v("scheduler", "stopping");
            }
            else {
                Log.v("scheduler", "running"); //checking if Loop is running properly
                long date = System.currentTimeMillis();
                SimpleDateFormat systime = new SimpleDateFormat("kk:mm"); //Formatting System time to compare it with the input
                String systimeString = systime.format(date);
                Log.v("time", ""+systimeString); //Checking the Format on System time

                String fromTime = editFromTime.getText().toString().trim();
                String toTime = editToTime.getText().toString().trim();

                if(fromTime.isEmpty()){
                    editFromTime.setText("18:00");
                    fromTime = editFromTime.getText().toString().trim();
                }
                if(toTime.isEmpty()){
                    editToTime.setText("06:00");
                    toTime = editToTime.getText().toString().trim();
                }
                Log.v("inputs", ""+fromTime+" "+toTime); //Checking Inputs

                if(systimeString.equals(fromTime)){
                    Log.v("compare", "Time to CLOSE!");
                    //Blinds Logic to CLOSE goes here
                }
                if(systimeString.equals(toTime)){
                    Log.v("compare", "Time to OPEN!");
                    //Blinds Logic to OPEN goes here
                }
            }
    }
}