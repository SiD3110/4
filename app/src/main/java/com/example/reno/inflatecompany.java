package com.example.reno;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import static com.example.reno.R.layout.inflatecompany;

public class inflatecompany extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inflatecompany);


      // Intent intent=getIntent();
       /*final  String item2=intent.getStringExtra("item1");
        if (item2.equals("amazon")){
            ImageView image =(ImageView)findViewById(R.id.imageView1234);
            image.setImageResource(R.drawable.amazon);
        }

            TextView text=(TextView)findViewById(R.id.t);

        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (item2.equals("amazon")){

                   /* LinearLayout layout=(LinearLayout)admin.findViewById(R.id.linearlayout);
                    View v1= getLayoutInflater().inflate(inflatecompany,layout,true);
                    layout.addView(v1);
                    Intent in=new Intent(inflatecompany.this,admin.class);
                    in.putExtra("item1",item2);
                    startActivity(in);
                }

            }
        });*/



    }
}
