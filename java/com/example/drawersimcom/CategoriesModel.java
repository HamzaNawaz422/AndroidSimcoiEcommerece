package com.example.drawersimcom;

import com.example.drawersimcom.CategoriesData;

import java.util.List;

public class CategoriesModel {
    private String success;
    private String message;
    private String responseCode;
    private List<CategoriesData> data;

    public String getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public List<CategoriesData> getData() {
        return data;
    }
    public CategoriesModel(String success, String message, String responseCode, List<CategoriesData> data) {
        this.success = success;
        this.message = message;
        this.responseCode = responseCode;
        this.data = data;
    }

}
