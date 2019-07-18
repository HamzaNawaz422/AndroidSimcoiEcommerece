package com.example.drawersimcom;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class login extends AppCompatActivity {

    TextView gosignup, forget, skip;
    Button login_btn;
    EditText email,password,user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        gosignup = findViewById(R.id.gosignuplink);
        forget = findViewById(R.id.forget);
        skip = findViewById(R.id.skiplogin);
        login_btn = findViewById(R.id.login);
        email = findViewById(R.id.email);
        password = findViewById(R.id.passwor);
        user = findViewById(R.id.user);
        gosignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signup = new Intent(login.this, sign_up.class);
                startActivity(signup);
            }
        });

        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(login.this, forget_password.class);
                startActivity(intent1);
            }
        });
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent skipp = new Intent(login.this, DrawerSim.class);
                startActivity(skipp);
            }
        });


        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              String  Email1 = email.getText().toString().trim();
              String  Password1 = password.getText().toString().trim();
               String Type1 = user.getText().toString().trim();
                Call<LoginModel> call = RetrofitClient
                        .getInstance()
                        .getApi()
                        .login(Email1, Password1, Type1);

                call.enqueue(new Callback<LoginModel>() {
                    @Override
                    public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {

                        LoginModel s = response.body();
                        if (s.getSuccess().equals("true")) {
                            Toast.makeText(getApplicationContext(), s.getMessage(), Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(getApplicationContext(), DrawerSim.class);
                            startActivity(intent);

                        } else {
                            Toast.makeText(getApplicationContext(), s.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }

                    /* Do user registration using the api call*/
                    @Override
                    public void onFailure(Call<LoginModel> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                    }

                });

            }
        });
    }



}
