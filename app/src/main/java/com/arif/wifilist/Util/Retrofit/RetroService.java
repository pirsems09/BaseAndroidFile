package com.arif.wifilist.Util.Retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroService {
    private static final String ROOT_URL = "urlMainAdress";
    private static Retrofit retrofit = null;
    private static Gson gson = new GsonBuilder().setLenient().create();

    public RetroService() {

    }

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(ROOT_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static RetroInterface getRetroInterface() {
        return getRetrofitInstance().create(RetroInterface.class);
    }
}


