package com.example.finalproject_diploma;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ProductModel implements Serializable {

    @SerializedName("name")
    private String productTitle;
    @SerializedName("title")
    private String productDescp;
    private String productButton;
    @SerializedName("price_final_text")
    private String getProductPrice;
    @SerializedName("avatar")
    private String productImage;


    public ProductModel(String productTitle, String productDescp , String getProductPrice) {
        this.productTitle = productTitle;
        this.productDescp = productDescp;
        this.getProductPrice = getProductPrice;
    }

    public ProductModel(){}

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public void setProductDescp(String productDescp) {
        this.productDescp = productDescp;
    }

    public void setProductButton(String productButton) {
        this.productButton = productButton;
    }

    public void setGetProductPrice(String getProductPrice) {
        this.getProductPrice = getProductPrice;
    }

    public String getProductImage() {
        return productImage;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public String getProductDescp() {
        return productDescp;
    }

    public String getProductButton() {
        return productButton;
    }

    public String getGetProductPrice() {
        return getProductPrice;
    }
}
