package com.example.retrofitlogindemo;


import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiSet {
    @FormUrlEncoded
    @POST("demoLogin.php")
    Call<Model> verifyUser(
      @Field("username") String username,
      @Field("password") String password
    );
}
