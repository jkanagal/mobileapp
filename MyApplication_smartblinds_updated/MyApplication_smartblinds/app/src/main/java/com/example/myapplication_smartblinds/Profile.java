package com.example.myapplication_smartblinds;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Profile extends AppCompatActivity {
    private FirebaseUser user;
    private DatabaseReference reference;
    private String uID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users");
        uID = user.getUid();

        final TextView greetingTextView = (TextView) findViewById(R.id.editProfile);
        final TextView fullNameTextView = (TextView) findViewById(R.id.editName);
        final TextView emailTextView = (TextView) findViewById(R.id.editEmail);
        final TextView temperatureTextView = (TextView) findViewById(R.id.editTemperature);

        reference.child(uID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User userProfile = snapshot.getValue(User.class);

                if (userProfile != null){
                    String fullName = userProfile.getfullName();
                    String email = userProfile.getemail();
                    String desiredtemp = userProfile.getdesiredtemp();

                    greetingTextView.setText(fullName+"!");
                    fullNameTextView.setText(fullName);
                    emailTextView.setText(email);
                    temperatureTextView.setText(desiredtemp);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Profile.this, "Something went wrong!", Toast.LENGTH_LONG).show();
            }
        });

    }
}