package com.example.drawersimcom;

public class ProductModel {
    private String success;
    private String message;
    private String responseCode;
    private ProductData data;

    public String getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public ProductData getData() {
        return data;
    }

    public ProductModel(String success, String message, String responseCode, ProductData data) {
        this.success = success;
        this.message = message;
        this.responseCode = responseCode;
        this.data = data;
    }

}
