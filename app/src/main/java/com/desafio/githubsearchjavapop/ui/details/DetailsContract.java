package com.desafio.githubsearchjavapop.ui.details;

import com.desafio.githubsearchjavapop.model.PullRequestDetail;

import java.util.List;

public interface DetailsContract {
    public interface View {
        void showGithubRepositories(List<PullRequestDetail> pullRequestDetails);
        void showLoading();
        void hideLoading();
        void showError();
    }

    public interface Presenter {
        void onInit(String login, String repoName);

    }
}
