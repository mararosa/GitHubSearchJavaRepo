package com.desafio.githubsearchjavapop.data;

import android.util.Log;

import com.desafio.githubsearchjavapop.data.remote.api.GetGithubRepositoriesApi;
import com.desafio.githubsearchjavapop.model.ItemResponse;
import com.desafio.githubsearchjavapop.model.RepositoryDetail;
import com.desafio.githubsearchjavapop.utils.Callback;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class GithubRepositoryImpl implements GithubRepository {

    private GetGithubRepositoriesApi mGetGithubRepositoriesApi;

    public GithubRepositoryImpl(GetGithubRepositoriesApi getGithubRepositoriesApi) {
        mGetGithubRepositoriesApi = getGithubRepositoriesApi;
    }


    @Override
    public void getRepositories(final Callback<List<RepositoryDetail>> callback) {
        try {
            Call<ItemResponse> call = mGetGithubRepositoriesApi.getItems();
            call.enqueue(new retrofit2.Callback<ItemResponse>() {
                @Override
                public void onResponse(Call<ItemResponse> call, Response<ItemResponse> response) {
                    List<RepositoryDetail> repositoryDetails = response.body().getRepositoryDetails();
                    callback.onCompleted(repositoryDetails);
                }

                @Override
                public void onFailure(Call<ItemResponse> call, Throwable t) {
                    Log.d("Error", t.getMessage());
                    callback.onError();
                }
            });
        } catch (Exception e) {
            Log.d ("Error", e.getMessage());
            callback.onError();
        }
    }
}
