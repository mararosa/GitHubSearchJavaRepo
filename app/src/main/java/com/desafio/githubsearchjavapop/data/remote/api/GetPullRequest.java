package com.desafio.githubsearchjavapop.data.remote.api;

import retrofit2.http.GET;

public interface GetPullRequest {
    @GET("https://github.com/<login>/<repoName>/pulls")


}
