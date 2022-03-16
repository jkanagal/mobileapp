package com.example.myapplication_smartblinds;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
Button regtomain;
ToggleButton tb;
TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        regtomain=(Button)findViewById(R.id.loginmain);
        regtomain.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                openLoginPage();}
            });




    }

    public void openLoginPage(){
        Intent intent=new Intent(this, login_page.class);
        startActivity(intent);
    }



}



