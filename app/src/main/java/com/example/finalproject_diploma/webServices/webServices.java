package com.example.finalproject_diploma.webServices;

import retrofit2.Call;
import retrofit2.http.GET;

public interface webServices {
    @GET("products")
    Call<ProductsResponse> getproducts();
}
