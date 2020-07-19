package com.desafio.githubsearchjavapop.data;

import android.util.Log;

import com.desafio.githubsearchjavapop.data.remote.api.PullRequestRestApi;
import com.desafio.githubsearchjavapop.model.PullRequestDetail;
import com.desafio.githubsearchjavapop.utils.Callback;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class GithubPullImpl implements GithubPull {

    PullRequestRestApi mPullRequestRestApi;

    public GithubPullImpl(PullRequestRestApi pullRequestRestApi) {
        mPullRequestRestApi = pullRequestRestApi;
    }

    @Override
    public void getPullRequest(String login, String repoName, final Callback<List<PullRequestDetail>> callback) {
        try {
            Call<List<PullRequestDetail>> call = mPullRequestRestApi.getPullRequest(login, repoName);
            call.enqueue(new retrofit2.Callback<List<PullRequestDetail>>(){
                @Override
                public void onResponse(Call<List<PullRequestDetail>> call, Response<List<PullRequestDetail>> response) {
                    List<PullRequestDetail> detailList = response.body();
                    callback.onCompleted(detailList);
                }

                @Override
                public void onFailure(Call<List<PullRequestDetail>> call, Throwable t) {
                    Log.d("Fail", t.getMessage());
                    callback.onError();
                }
            });
        } catch (Exception e) {
            Log.d("Error", e.getMessage());
            callback.onError();
        }
    }
}
