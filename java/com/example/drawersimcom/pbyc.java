package com.example.drawersimcom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class pbyc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pbyc);

        final ListView listView=findViewById(R.id.listView);

        Call<CategoriesModel> call = RetrofitClient
                .getInstance()
                .getApi()
                .getAllCategories();

        call.enqueue(new Callback<CategoriesModel>() {
            @Override
            public void onResponse(Call<CategoriesModel> call, Response<CategoriesModel> response) {
                CategoriesModel model=response.body();

                List<CategoriesData> data=model.getData();

                String[] categories=new String[data.size()];
                for(int i=0;i<data.size();i++) {
                    categories[i] = data.get(i).getCategory_name();
                }
                listView.setAdapter(
                        new ArrayAdapter<String>(
                                getApplicationContext(),
                                android.R.layout.simple_list_item_1,
                                categories
                        )
                );

            }

            /* Do user registration using the api call*/
            @Override
            public void onFailure(Call<CategoriesModel> call, Throwable t) {
                Toast.makeText(pbyc.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }

        });
    }
}
