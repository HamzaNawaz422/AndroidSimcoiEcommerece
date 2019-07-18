package com.example.drawersimcom;

import com.example.drawersimcom.AllProductData;

import java.util.List;

public class AllProductModel {
    String success,message,responseCode;
    List<AllProductData> data;

    public AllProductModel(String success, String message, String responseCode, List<AllProductData> data) {
        this.success = success;
        this.message = message;
        this.responseCode = responseCode;
        this.data = data;
    }

    public String getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public List<AllProductData> getData() {
        return data;
    }
}
