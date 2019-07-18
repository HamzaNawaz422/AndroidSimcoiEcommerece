package com.example.drawersimcom;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class home extends AppCompatActivity {

    Context context;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        listView = findViewById(R.id.listview);
        context = home.this;
        Call<AllProductModel> call = RetrofitClient
                .getInstance()
                .getApi()
                .products();
        call.enqueue(new Callback<AllProductModel>() {
            @Override
            public void onResponse(Call<AllProductModel> call, Response<AllProductModel> response) {

                AllProductModel model = response.body();
                List<AllProductData> data = model.getData();

                if (model.getSuccess().equals("true")) {
                    String[] products = new String[data.size()];
                    for (int i = 0; i < data.size(); i++) {
                        products[i] = data.get(i).getProductName();
                    }
                    listView.setAdapter(
                            new ArrayAdapter<String>(
                                    getApplicationContext(),
                                    android.R.layout.simple_list_item_1,
                                    products
                            )
                    );
                    Toast.makeText(context, "Success", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(context, "Failure", Toast.LENGTH_LONG).show();
                }
            }
            /* Do user registration using the api call*/
            @Override
            public void onFailure(Call<AllProductModel> call, Throwable t) {
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_LONG).show();
            }

        });


    }
}
