package com.example.myapplication_smartblinds;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

public class privacy_page extends AppCompatActivity {
ToggleButton tb;
TextView tx3,tx4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_page);

        tb=findViewById(R.id.toggleButton);

        tx3=findViewById(R.id.textView7);

        tb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(tb.isChecked()){
                    tx3.setText("IS ON");
                    tx3.setVisibility(View.VISIBLE);
                }
                else{
                    tx3.setVisibility(View.GONE);
                }

            }
        });


    }
}