package com.example.myapplication_smartblinds;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class manual_page extends AppCompatActivity {

    BlindController bc = new BlindController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual_page);
    }

    public void blindsUp (View view){
        bc.blindsUp();
    }

    public void blindsDown (View view){
        bc.blindsDown();
    }
}