package com.desafio.githubsearchjavapop.api;

import com.desafio.githubsearchjavapop.model.ItemResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Service {
    @GET("/search/repositories?q=language:Java&sort=forks&order=desc")
    Call<ItemResponse> getItems();
}
