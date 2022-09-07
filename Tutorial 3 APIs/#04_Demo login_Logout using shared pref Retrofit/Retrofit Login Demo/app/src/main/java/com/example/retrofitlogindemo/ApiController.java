package com.example.retrofitlogindemo;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiController {
    private static final String url="http://192.168.1.34//Api/";
    private static Retrofit retrofit;
    private static ApiController clientObject;

    ApiController(){
        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized ApiController getInstance(){
        if(clientObject == null)
            clientObject = new ApiController();
        return clientObject;
    }

    ApiSet getApi(){
        return retrofit.create(ApiSet.class);
    }
}
