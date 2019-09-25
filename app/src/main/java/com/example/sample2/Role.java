package com.example.sample2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;

public class Role extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_role);

        Button  student = (Button)findViewById(R.id.button2);
        student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToStudent();
            }
        });

        Button  writer = (Button)findViewById(R.id.button3);
        writer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToWriter();
            }
        });
    }

    private void goToStudent() {
        Intent intent = new Intent(this, StudentForm.class);
        startActivity(intent);
    }

    private void goToWriter() {
        Intent intent = new Intent(this, WriterForm.class);
        startActivity(intent);
    }
}
