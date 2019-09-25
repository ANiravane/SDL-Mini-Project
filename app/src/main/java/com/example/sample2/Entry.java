package com.example.sample2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.widget.Button;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Entry extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText e, p;
    private Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry);


        e = (EditText)findViewById(R.id.editText);
        p = (EditText)findViewById(R.id.editText2);
        signup = (Button)findViewById(R.id.button7);
        mAuth = FirebaseAuth.getInstance();

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                createAccount();
            }
        });


    }

    public void createAccount()
    {
        final String email = e.getText().toString();
        final String password = p.getText().toString();



        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(Entry.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                Toast.makeText(Entry.this, "createUserWithEmail:onComplete:" + task.isSuccessful(), Toast.LENGTH_SHORT).show();
                //progressBar.setVisibility(View.GONE);
                // If sign in fails, display a message to the user. If sign in succeeds
                // the auth state listener will be notified and logic to handle the
                // signed in user can be handled in the listener.
                if (!task.isSuccessful()) {
                    Toast.makeText(Entry.this, "Authentication failed." + task.getException(),
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(getApplicationContext(), Role.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

}
