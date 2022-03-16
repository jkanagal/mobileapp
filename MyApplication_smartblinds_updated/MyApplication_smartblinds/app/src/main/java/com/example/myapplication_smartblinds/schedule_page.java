package com.example.myapplication_smartblinds;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.TextView;

public class schedule_page extends AppCompatActivity {
    CalendarView cV;
    TextView myDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_page);

        cV=(CalendarView)findViewById(R.id.calendarView);
        myDate=(TextView)findViewById(R.id.textView5);
    cV.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
        @Override
        public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {

                String date=(month+1)+"/"+dayOfMonth+"/"+year;
                myDate.setText(date);
            }


    });

    }
}