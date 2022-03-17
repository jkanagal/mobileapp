package com.example.myapplication_smartblinds;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class login_page extends AppCompatActivity {
    Button logintohome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);


        logintohome=(Button)findViewById(R.id.login_home);
        logintohome.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                openHomePage();}
        });



    }

    public void openHomePage(){
        Intent intent=new Intent(this, home_page.class);
        startActivity(intent);
    }


}