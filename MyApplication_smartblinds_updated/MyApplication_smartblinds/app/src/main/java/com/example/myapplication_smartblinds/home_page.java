package com.example.myapplication_smartblinds;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class home_page extends AppCompatActivity {
    TextView m_img;
    ImageView m_icon;
    TextView a_img;
    ImageView a_icon;
    TextView p_img;
    ImageView p_icon;
    TextView s_img;
    ImageView s_icon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        m_img=(TextView) findViewById(R.id.textView10);
        m_img.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                openManualPage();}
        });
        m_icon=(ImageView) findViewById(R.id.imageView11);
        m_icon.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                openManualPage();}
        });

        s_img=(TextView) findViewById(R.id.textView11);
        s_img.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                openSchedPage();}
        });
        s_icon=(ImageView) findViewById(R.id.imageView12);
        s_icon.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                openSchedPage();}
        });

        a_img=(TextView) findViewById(R.id.textView12);
        a_img.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                openAutoPage();}
        });
        a_icon=(ImageView) findViewById(R.id.imageView13);
        a_icon.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                openAutoPage();}
        });

        p_img=(TextView) findViewById(R.id.textView9);
        p_img.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                openPrivacyPage();}
        });
        p_icon=(ImageView) findViewById(R.id.imageView10);
        p_icon.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                openPrivacyPage();}
        });





    }

    public void openManualPage(){
        Intent intent=new Intent(this, manual_page.class);
        startActivity(intent);
    }

    public void openPrivacyPage(){
        Intent intent=new Intent(this, privacy_page.class);
        startActivity(intent);
    }

    public void openSchedPage(){
        Intent intent=new Intent(this, schedule_page.class);
        startActivity(intent);
    }

    public void openAutoPage(){
        Intent intent=new Intent(this, auto_page.class);
        startActivity(intent);
    }



}