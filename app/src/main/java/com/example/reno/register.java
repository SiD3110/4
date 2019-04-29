package com.example.reno;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

import java.util.regex.Pattern;

public class register extends AppCompatActivity {
    TextInputEditText textInputEditText,textInputEditText1,textInputEditText2;
    Button butt;
    private FirebaseAuth mauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mauth=FirebaseAuth.getInstance();
        textInputEditText = (TextInputEditText) findViewById(R.id.editt);
        butt = (Button) findViewById(R.id.button);
        textInputEditText1 = (TextInputEditText) findViewById(R.id.ps);
        textInputEditText2 = (TextInputEditText) findViewById(R.id.cps);


            butt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String email = textInputEditText.getText().toString().trim();
                    String pass = textInputEditText1.getText().toString().trim();
                    String pass1 = textInputEditText2.getText().toString().trim();
                    if (email.isEmpty()) {
                        textInputEditText.setError("Email is required");
                        textInputEditText.requestFocus();
                        return;
                    }
                    if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                        textInputEditText.setError("Enter valid Email address");
                        textInputEditText.requestFocus();
                        return;
                    }
                    if (pass.isEmpty()) {
                        textInputEditText1.setError("Password is required");
                        textInputEditText1.requestFocus();
                        return;
                    }
                    if (pass.length() < 6) {
                        textInputEditText1.setError("Mininum length should be more than 6");
                        textInputEditText1.requestFocus();
                        return;
                    }
                    if (!pass.equals(pass1)) {
                        textInputEditText2.setError("Incorrect Password");
                        textInputEditText2.requestFocus();
                        return;

                    }
              /*  mauth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(register.this, "Registration Successfull", Toast.LENGTH_SHORT).show();
                        }


                    }


                });*/
                    mauth.createUserWithEmailAndPassword(email, pass)
                            .addOnCompleteListener(register.this, new OnCompleteListener<AuthResult>() {

                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(register.this, "Registration Successfull", Toast.LENGTH_SHORT).show();
                                    }
                                    else{
                                        if(task.getException() instanceof FirebaseAuthUserCollisionException){
                                            Toast.makeText(register.this, "You are already Registered", Toast.LENGTH_LONG).show();
                                        }
                                        else{
                                            Toast.makeText(register.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                                        }
                                    }
                                }


                            });
                }
            });



   /* public void loginpage(View view) {
        Intent in=new Intent(this,loginpage.class);
                startActivity(in);
*/

        }


    public void loginpage(View view){
        Intent in = new Intent(this, loginpage.class);
        startActivity(in);}}


