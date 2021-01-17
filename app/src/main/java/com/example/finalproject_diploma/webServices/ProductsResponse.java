package com.example.finalproject_diploma.webServices;

import com.example.finalproject_diploma.ProductModel;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProductsResponse {
    @SerializedName("products")
    private List<ProductModel> productlList;

    public List<ProductModel> getProductlList() {
        return productlList;
    }

    public void setProductlList(List<ProductModel> productlList) {
        this.productlList = productlList;
    }
}
