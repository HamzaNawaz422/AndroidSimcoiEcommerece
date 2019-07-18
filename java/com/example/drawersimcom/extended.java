package com.example.drawersimcom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

public class extended extends AppCompatActivity {

    FrameLayout fr1,fr2,fr3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extended);
        fr1 = findViewById(R.id.jewellery_frame);
        fr2 = findViewById(R.id.shoes_frame);
        fr3 = findViewById(R.id.electronic_frame);

    }

    public void jewellery_frame(View view) {
        fr1.setVisibility(View.VISIBLE);
        fr2.setVisibility(View.INVISIBLE);
        fr3.setVisibility(View.INVISIBLE);
    }

    public void electronic_frame(View view) {
        fr2.setVisibility(View.VISIBLE);
        fr1.setVisibility(View.INVISIBLE);
        fr3.setVisibility(View.INVISIBLE);
    }

    public void shoes_frame(View view) {
        fr3.setVisibility(View.VISIBLE);
        fr1.setVisibility(View.INVISIBLE);
        fr2.setVisibility(View.INVISIBLE);
    }
}
