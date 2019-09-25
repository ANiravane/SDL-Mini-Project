package com.example.sample2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.*;

public class HomeScreenStudent extends AppCompatActivity {
    private Button signout;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen_student);
        signout = (Button)findViewById(R.id.button4);
        mAuth = FirebaseAuth.getInstance();


        signout.setOnClickListener(new View.OnClickListener()
        {


            @Override
            public void onClick(View view) {
                mAuth.signOut();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
