package com.arif.wifilist.Util.Retrofit;

import com.arif.wifilist.Models.ModelExample;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetroInterface {

    //post
    @FormUrlEncoded
    @POST("auth/login")
    Call<ModelExample> getUserData(
            @Field("login[email]") String email,
            @Field("login[password]") String password
    );

    //get
    @GET("home")
    Call<ModelExample> showcaseAdvert();

    //part
    @GET("companies/detail/{id}")
    Call<ModelExample> getDetailList(@Path("id") String id);

    //query
    @GET("location/towns?cityId")
    Call<ModelExample> getTowns(@Query("cityId") String cityId);

    //header
    @GET("student/point")
    Call<ModelExample> getPoint(@Header("Authorization") String authorization);

    //headers and body
    @Headers("Content-Type:application/json")
    @POST("/api/v2/insertPromise")
    Call<ModelExample> insertPromise(
            @Body Map<String, String> body);

}
