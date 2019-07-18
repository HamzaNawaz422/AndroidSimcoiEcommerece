package com.example.drawersimcom;

import com.example.drawersimcom.AllProductModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {

    @FormUrlEncoded
    @POST("login")
    Call<LoginModel> login(
            @Field("email") String email,
            @Field("password") String password,
            @Field("logintype") String logintype
    );

    @FormUrlEncoded
    @POST("register")
    Call<LoginModel> register(
            @Field("name") String name,
            @Field("email") String email,
            @Field("password") String password,
            @Field("logintype") String logintype
    );

    @GET("allproducts")
    Call<AllProductModel> products();

    @FormUrlEncoded
    @POST("product")
    Call<ProductModel> products(
            @Field("product_id") String product_id
    );
    @FormUrlEncoded
    @POST("forgot")
    Call<forget_password>forgetPassword(
            @Field("email") String email
    );
    @GET("pbyc")
    Call<CategoriesModel> getAllCategories();

}
