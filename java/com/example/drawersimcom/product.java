package com.example.drawersimcom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class product extends AppCompatActivity {

    EditText productid;
    Button enter,em;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        enter=findViewById(R.id.enterbtn);



        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                productid = (EditText) findViewById(R.id.email);
                final ListView listView = findViewById(R.id.listView);
                String id = productid.getText().toString().trim();

                Call<ProductModel> call = RetrofitClient
                        .getInstance()
                        .getApi()
                        .products(id);

                call.enqueue(new Callback<ProductModel>() {
                    @Override
                    public void onResponse(Call<ProductModel> call, Response<ProductModel> response) {

                        ProductModel model = response.body();
                        ProductData data = model.getData();

                        String[] products = new String[2];
                        products[0] = data.getProductId();
                        products[1] = data.getProductName();
                        if (products == null) {
                            Toast.makeText(product.this, "Sorry! no product Found", Toast.LENGTH_SHORT).show();
                        } else {
                            listView.setAdapter(
                                    new ArrayAdapter<String>(
                                            getApplicationContext(),
                                            android.R.layout.simple_list_item_1,
                                            products
                                    )
                            );
                        }
                    }

                    /* Do user registration using the api call*/
                    @Override
                    public void onFailure(Call<ProductModel> call, Throwable t) {
                        Toast.makeText(product.this, t.getMessage(), Toast.LENGTH_LONG).show();
                    }

                });
            }
        });
    }
}
