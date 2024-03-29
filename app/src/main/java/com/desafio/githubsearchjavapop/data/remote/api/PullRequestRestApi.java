package com.desafio.githubsearchjavapop.data.remote.api;

import com.desafio.githubsearchjavapop.model.PullRequestDetail;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PullRequestRestApi {
    @GET("/repos/{name}/{repoName}/pulls")
    Call<List<PullRequestDetail>> getPullRequest(@Path("name") String name, @Path("repoName") String repoName);
}
