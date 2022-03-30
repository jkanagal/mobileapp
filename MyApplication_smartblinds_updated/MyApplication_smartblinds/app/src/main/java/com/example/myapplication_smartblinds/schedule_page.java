package com.example.myapplication_smartblinds;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.widget.EditText;

import com.google.android.material.switchmaterial.SwitchMaterial;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class schedule_page extends AppCompatActivity{
    private SwitchMaterial toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_page);

        toggle = (SwitchMaterial) findViewById(R.id.scheduleToggle);
        toggle.setOnCheckedChangeListener((buttonView, isChecked) -> {
            Log.v("Switch State", ""+isChecked);
                scheduler(isChecked);
        });

    }

    private void scheduler(boolean isChecked) {
        SimpleDateFormat formatter = new SimpleDateFormat("H:mm");
        Date currentTime = Calendar.getInstance().getTime();
        EditText openTime = findViewById(R.id.editFromTime);
        EditText closeTime = findViewById(R.id.editToTime);

        String sysTimeStr = formatter.format(currentTime);
        String openTimeStr = openTime.getText().toString();
        String closeTimeStr = closeTime.getText().toString();
        try {
            Date sysTimeFormatted = formatter.parse(sysTimeStr);
            Date openTimeFormatted = formatter.parse(openTimeStr);
            Date closeTimeFormatted = formatter.parse(closeTimeStr);
            BlindController bc = new BlindController();

            if(openTimeFormatted.before(sysTimeFormatted) && closeTimeFormatted.after(sysTimeFormatted)){
                bc.blindsUp();
                Log.v("Blind State", "Opening!");
            } else {
                bc.blindsDown();
                Log.v("Blind State", "Closing!");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}