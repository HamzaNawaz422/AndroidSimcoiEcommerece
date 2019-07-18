package com.example.drawersimcom;

import android.content.Intent;
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

public class sign_up extends AppCompatActivity {

    TextView gologin;
    EditText fname, email, password, user;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        gologin = findViewById(R.id.gologin);
        fname = findViewById(R.id.nameid);
        email = findViewById(R.id.email);
        password = findViewById(R.id.passwor);
        user = findViewById(R.id.cnfrmpassword);
        login=findViewById(R.id.login);


gologin.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(sign_up.this,login.class);
        startActivity(intent);
    }
});


    login.setOnClickListener(new View.OnClickListener()

    {
        @Override
        public void onClick (View v){
        String Name = fname.getText().toString().trim();
        String Email = email.getText().toString().trim();
        String Password = password.getText().toString().trim();
        String Type = user.getText().toString().trim();


        Call<LoginModel> call = RetrofitClient
                .getInstance()
                .getApi()
                .register(Name, Email, Password, Type);

        call.enqueue(new Callback<LoginModel>() {
            @Override
            public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {

                LoginModel s = response.body();
                if (s.getSuccess().equals("true")) {
                    Toast.makeText(getApplicationContext(), s.getMessage(), Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(), login.class);
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






