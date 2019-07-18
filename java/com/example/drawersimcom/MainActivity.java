package com.example.drawersimcom;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    final String Key_Pref="Login_Key";
    int login_key;
    SharedPreferences Login_preferences,Key_preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Key_preferences=getSharedPreferences(Key_Pref,MODE_PRIVATE);
        login_key=Key_preferences.getInt("Key",0);
        final Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(getApplicationContext(),login.class);
                //  Intent intent1=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);

            }
        },3*1000);

    }
}
