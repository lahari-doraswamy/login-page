package com.example.login;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {
    @FormUrlEncoded
    @POST("https://reqres.in/api/users/2?")
    Call<User> getUserInformation(@Field("id")String id, @Field("email")String email,@Field("first_name")String first_name,@Field("last_name")String last_name,@Field("support") String support,@Field("text")String text);

}
