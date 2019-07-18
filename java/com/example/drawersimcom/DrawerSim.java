package com.example.drawersimcom;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ViewFlipper;

public class DrawerSim extends AppCompatActivity
         {

             ViewFlipper v_flipper;
             Context context;
             ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_sim);

        listView = findViewById(R.id.listView);
        context = DrawerSim.this;
        int images[]={R.drawable.jewellery,R.drawable.shoes,R.drawable.electronic};
        v_flipper = findViewById(R.id.flipperView);

        for(int image:images)
        {
            flipperImages(image);
        }

    }

             public void flipperImages(int images)
             {
                 ImageView imageView = new ImageView(this);
                 imageView.setBackgroundResource(images);
                 v_flipper.addView(imageView);
                 v_flipper.setFlipInterval(2500);
                 v_flipper.setAutoStart(true);

                 v_flipper.setOutAnimation(this,android.R.anim.slide_out_right);
                 v_flipper.setInAnimation(this,android.R.anim.slide_in_left);
             }

             public void extended_activity (View view){
                 Intent intent = new Intent(getApplicationContext(), extended.class);
                 startActivity(intent);
             }

             public void allProducts(View view) {
                 Intent intent = new Intent(getApplicationContext(),DrawerSim.class);
                 startActivity(intent);
             }

             public void searchProduct(View view) {
                 Intent intent = new Intent(getApplicationContext(),product.class);
                 startActivity(intent);
             }

             public void pbyc(View view) {
                 Intent intent = new Intent(getApplicationContext(),pbyc.class);
                 startActivity(intent);
             }
}
