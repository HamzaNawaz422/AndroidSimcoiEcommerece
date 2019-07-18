package com.example.drawersimcom;

public class ProductData
{
    private String productName;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    private String productId;

    public ProductData(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }
}
