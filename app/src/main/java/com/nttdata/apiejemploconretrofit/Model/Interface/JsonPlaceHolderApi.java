package com.nttdata.apiejemploconretrofit.Model.Interface;

import com.nttdata.apiejemploconretrofit.Model.Posts;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {

    //Trae información de la página, especificada en el @GET
    @GET("posts")
    Call<List<Posts>> getPosts();


}
