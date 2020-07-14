package com.desafio.githubsearchjavapop.data;

import android.util.Log;

import com.desafio.githubsearchjavapop.data.remote.api.GetPullRequest;
import com.desafio.githubsearchjavapop.model.PullDetail;
import com.desafio.githubsearchjavapop.utils.Callback;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class GithubPullImpl implements GithubPull {

    GetPullRequest mGetPullRequest;

    public GithubPullImpl(GetPullRequest getPullRequest) {
        mGetPullRequest = getPullRequest;
    }

    @Override
    public void getPullRequest(String login, String repoName, final Callback<List<PullDetail>> callback) {
        try {
            Call<List<PullDetail>> call = mGetPullRequest.getPullRequest(login, repoName);
            call.enqueue(new retrofit2.Callback<List<PullDetail>>(){
                @Override
                public void onResponse(Call<List<PullDetail>> call, Response<List<PullDetail>> response) {
                    List<PullDetail> detailList = response.body();
                    callback.onCompleted(detailList);
                }

                @Override
                public void onFailure(Call<List<PullDetail>> call, Throwable t) {
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
