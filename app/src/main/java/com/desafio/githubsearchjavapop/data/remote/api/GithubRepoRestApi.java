package com.desafio.githubsearchjavapop.data.remote.api;

import com.desafio.githubsearchjavapop.model.ItemResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GithubRepoRestApi {
    @GET("/search/repositories?q=language:Java&sort=forks&order=desc")
    Call<ItemResponse> getItems();
}
