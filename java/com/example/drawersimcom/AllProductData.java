package com.example.drawersimcom;

public class AllProductData {
    String productid,productName,currency,sellprice,mrp,size,quantity;

    public AllProductData(String productid, String productName, String currency, String sellprice, String mrp, String size, String quantity) {
        this.productid = productid;
        this.productName = productName;
        this.currency = currency;
        this.sellprice = sellprice;
        this.mrp = mrp;
        this.size = size;
        this.quantity = quantity;
    }

    public String getProductid() {
        return productid;
    }

    public String getProductName() {
        return productName;
    }

    public String getCurrency() {
        return currency;
    }

    public String getSellprice() {
        return sellprice;
    }

    public String getMrp() {
        return mrp;
    }

    public String getSize() {
        return size;
    }

    public String getQuantity() {
        return quantity;
    }
}
