package com.example.reno;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class loginpage extends AppCompatActivity {
    FirebaseAuth mauth;
    TextInputEditText textInputEditText,textInputEditText1;
    ProgressBar progressBar;
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);
        final Spinner spinner=(Spinner)findViewById(R.id.spinner_id);
        Button button=(Button)findViewById(R.id.button_id);
        textInputEditText1 = (TextInputEditText) findViewById(R.id.passs);
        textInputEditText = (TextInputEditText) findViewById(R.id.emaill);
        sp = getSharedPreferences("login",MODE_PRIVATE);
        mauth=FirebaseAuth.getInstance();
        if(sp.getBoolean("logged",true)){
            Intent in=new Intent(loginpage.this,h.class);
            in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(in);
            finish();
        }
        List<String> categories;
        categories = new ArrayList<String>();
        categories.add("Admin");
        categories.add("Student");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
       /* button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = spinner.getSelectedItem().toString();
                if (item.equals("Student")){
                    Intent in=new Intent(loginpage.this,h.class);
                    startActivity(in);
                }
                else if (item.equals("Admin")){
                    Intent in=new Intent(loginpage.this,admin.class);
                    startActivity(in);
                }
            }
        });*/
       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String email = textInputEditText.getText().toString().trim();
               String pass = textInputEditText1.getText().toString().trim();

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
               mauth.signInWithEmailAndPassword(email, pass)
                       .addOnCompleteListener(loginpage.this, new OnCompleteListener<AuthResult>() {
                           @Override
                           public void onComplete(@NonNull Task<AuthResult> task) {
                               if (task.isSuccessful()) {
                                   String item = spinner.getSelectedItem().toString();
                                   if (item.equals("Student")){
                                       Intent in=new Intent(loginpage.this,h.class);
                                       in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                       startActivity(in);
                                       sp.edit().putBoolean("logged",true).apply();
                                       finish();
                                   }
                                   else if (item.equals("Admin")){
                                       Intent in=new Intent(loginpage.this,admin.class);
                                       in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                       startActivity(in);
                                       sp.edit().putBoolean("logged",true).apply();
                                       finish();
                                   }
                                   // Sign in success, update UI with the signed-in user's information

                               } else {
                                   // If sign in fails, display a message to the user.

                                   Toast.makeText(loginpage.this, task.getException().getMessage(),
                                           Toast.LENGTH_SHORT).show();

                               }

                               // ...
                           }
                       });
           }
       });



    }
    public void registerit(View view)
    {
        Intent in=new Intent(this,register.class);
        startActivity(in);
    }






}


