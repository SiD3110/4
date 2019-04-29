package com.example.reno;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import static com.example.reno.R.drawable.accenture;
import static com.example.reno.R.layout.inflatecompany;

public class addcompany extends AppCompatActivity {
    DatabaseReference database;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcompany);
        database= FirebaseDatabase.getInstance().getReference("jobs");
        final Spinner spinner=(Spinner)findViewById(R.id.spinner_id);
        Button button=(Button)findViewById(R.id.button_idd);
        final Spinner spinner2=(Spinner)findViewById(R.id.spinner_idd);
        Button button2=(Button)findViewById(R.id.button_iddd);
        editText=(EditText)findViewById(R.id.etview);


        List<String> categories;
        categories = new ArrayList<String>();
        categories.add("amazon");
        categories.add("infosys");
        categories.add("tcs");
        categories.add("accenture");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
        spinner2.setAdapter(dataAdapter);
        final Toast toast=Toast.makeText(getApplicationContext(),"Job Added ",Toast.LENGTH_SHORT);
        final Toast toast2=Toast.makeText(getApplicationContext(),"Job Deleted",Toast.LENGTH_SHORT);

        // final  String item = spinner.getSelectedItem().toString();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  String item = spinner.getSelectedItem().toString();
                String date=editText.getText().toString().trim();

                if (item.equals("amazon")){
                   // add(item);
                   // String date=editText.getText().toString().trim();
                    String img="https://firebasestorage.googleapis.com/v0/b/reno-d0586.appspot.com/o/amazon.jpg?alt=media&token=c84ef4bc-d0c3-4a4a-9df5-d5ce832b739d";
                    info i=new info(img,date);
                    database.child("amazon").setValue(i);
                    toast.show();

                    Intent in=new Intent(addcompany.this,admin.class);
                    //in.putExtra("item1",item);
                    startActivity(in);
                }
                else if (item.equals("tcs")){
                   // add1(item);
                    String img="https://firebasestorage.googleapis.com/v0/b/reno-d0586.appspot.com/o/tcs.jpg?alt=media&token=fb971f33-069f-4c37-99a4-6670af4c0d3a";
                    info i=new info(img,date);
                    database.child("tcs").setValue(i);
                    toast.show();
                   Intent in=new Intent(addcompany.this,admin.class);
                   startActivity(in);
               }
                else if (item.equals("accenture")){
                    //add2(item);
                    String img="https://firebasestorage.googleapis.com/v0/b/reno-d0586.appspot.com/o/accenture.jpg?alt=media&token=2e9bd0e4-8612-4b94-8b19-fa37ccc404df";
                    info i=new info(img,date);
                    database.child("accenture").setValue(i);
                    toast.show();
                    Intent in=new Intent(addcompany.this,admin.class);
                    startActivity(in);
                }
                else if (item.equals("infosys")){
                    //add3(item);
                    String img="https://firebasestorage.googleapis.com/v0/b/reno-d0586.appspot.com/o/infosys.png?alt=media&token=fcd37ee5-d88d-41ec-9fb1-784a7bacec99";
                    info i=new info(img,date);
                    database.child("infosys").setValue(i);
                    toast.show();
                    Intent in=new Intent(addcompany.this,admin.class);
                    startActivity(in);
                }
            }

            /*private void add3(String item) {

                 image[0] =(ImageView)findViewById(R.id.imageView1234);

                Drawable myDrawable = getResources().getDrawable(R.drawable.infosys);
                image[0].setImageDrawable(myDrawable);
               LinearLayout layout=(LinearLayout) findViewById(R.id.scroll);
                View v= getLayoutInflater().inflate(inflatecompany,layout,true);
                layout.addView(v);
            }


            private void add2(String item) {

                LinearLayout layout=(LinearLayout) findViewById(R.id.scroll);
                View v= getLayoutInflater().inflate(inflatecompany,layout,true);
                layout.addView(v);
                image[0] =(ImageView)findViewById(R.id.imageView1234);
                image[0].setImageResource(accenture);
            }

            private void add1(String item) {
                image[0] =(ImageView)findViewById(R.id.imageView1234);

                image[0].setImageResource(R.drawable.tcs);
                LinearLayout layout=(LinearLayout) findViewById(R.id.scroll);
                View v= getLayoutInflater().inflate(inflatecompany,layout,true);
                layout.addView(v);
            }

            private void add(String item) {
                 image[0] =(ImageView)findViewById(R.id.imageView1234);

                image[0].setImageResource(R.drawable.amazon);
                LinearLayout layout=(LinearLayout) findViewById(R.id.scroll);
                View v= getLayoutInflater().inflate(inflatecompany,layout,true);
                layout.addView(v);
            }*/
        });


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = spinner2.getSelectedItem().toString();

                if (item.equals("amazon")){
                    // add(item);

                    DatabaseReference d=FirebaseDatabase.getInstance().getReference("jobs").child(item);
                    d.removeValue();
                    toast2.show();
                    Intent in=new Intent(addcompany.this,admin.class);
                    //in.putExtra("item1",item);
                    startActivity(in);
                }
                else if (item.equals("tcs")){
                    // add1(item);

                    DatabaseReference d=FirebaseDatabase.getInstance().getReference("jobs").child(item);
                    d.removeValue();
                    toast2.show();

                    Intent in=new Intent(addcompany.this,admin.class);
                    startActivity(in);
                }
                else if (item.equals("accenture")){
                    //add2(item);
                    DatabaseReference d=FirebaseDatabase.getInstance().getReference("jobs").child(item);
                    d.removeValue();
                    toast2.show();
                    Intent in=new Intent(addcompany.this,admin.class);
                    startActivity(in);
                }
                else if (item.equals("infosys")){
                    //add3(item);
                    DatabaseReference d=FirebaseDatabase.getInstance().getReference("jobs").child(item);
                    d.removeValue();
                    toast2.show();
                   Intent in=new Intent(addcompany.this,admin.class);
                    startActivity(in);
                }
            }

            /*private void add3(String item) {

                 image[0] =(ImageView)findViewById(R.id.imageView1234);

                Drawable myDrawable = getResources().getDrawable(R.drawable.infosys);
                image[0].setImageDrawable(myDrawable);
               LinearLayout layout=(LinearLayout) findViewById(R.id.scroll);
                View v= getLayoutInflater().inflate(inflatecompany,layout,true);
                layout.addView(v);
            }


            private void add2(String item) {

                LinearLayout layout=(LinearLayout) findViewById(R.id.scroll);
                View v= getLayoutInflater().inflate(inflatecompany,layout,true);
                layout.addView(v);
                image[0] =(ImageView)findViewById(R.id.imageView1234);
                image[0].setImageResource(accenture);
            }

            private void add1(String item) {
                image[0] =(ImageView)findViewById(R.id.imageView1234);

                image[0].setImageResource(R.drawable.tcs);
                LinearLayout layout=(LinearLayout) findViewById(R.id.scroll);
                View v= getLayoutInflater().inflate(inflatecompany,layout,true);
                layout.addView(v);
            }

            private void add(String item) {
                 image[0] =(ImageView)findViewById(R.id.imageView1234);

                image[0].setImageResource(R.drawable.amazon);
                LinearLayout layout=(LinearLayout) findViewById(R.id.scroll);
                View v= getLayoutInflater().inflate(inflatecompany,layout,true);
                layout.addView(v);
            }*/
        });

    }


}
