package com.desafio.githubsearchjavapop.ui.details;

import com.desafio.githubsearchjavapop.data.GithubPull;
import com.desafio.githubsearchjavapop.model.PullDetail;
import com.desafio.githubsearchjavapop.utils.Callback;

import java.util.List;

public class DetailsPresenter  implements DetailsContract.Presenter{
    private DetailsContract.View view;
    private GithubPull mGithubPull;

    public DetailsPresenter(DetailsContract.View view, GithubPull githubPull) {
        this.view = view;
        mGithubPull = githubPull;
    }

    @Override
    public void onInit(String login, String repoName) {
        loadGithubRepository(login, repoName);
    }

    private void loadGithubRepository(String login, String repoName){
        view.showLoading();
        mGithubPull.getPullRequest(login, repoName, new Callback<List<PullDetail>>() {
            @Override
            public void onCompleted(List<PullDetail> data) {
                view.showGithubRepositories(data);
                view.hideLoading();
            }

            @Override
            public void onError() {
                view.showError();
            }
        });
    }
}
