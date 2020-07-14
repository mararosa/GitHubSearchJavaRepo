package com.desafio.githubsearchjavapop.data.remote.api;

import com.desafio.githubsearchjavapop.model.PullDetail;
import com.desafio.githubsearchjavapop.utils.Callback;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GetPullRequest {
    @GET("/repos/{name}/{repoName}/pulls")
    Call<List<PullDetail>> getPullRequest(@Path("name") String name, @Path("repoName") String repoName);
}
