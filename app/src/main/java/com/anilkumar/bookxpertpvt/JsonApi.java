package com.anilkumar.bookxpertpvt;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonApi {
    @GET("getownerslist/2021-01-16/payments/owner")
    Call<String> sendData();
}
