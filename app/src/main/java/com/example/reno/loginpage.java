package com.example.reno;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class loginpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);
    }
    public void registerit(View view)
    {
        Intent in=new Intent(this,register.class);
        startActivity(in);
    }

        public void homeit(View v){
            Intent in=new Intent(this,h.class);
            startActivity(in);
        }

}


