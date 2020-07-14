package com.desafio.githubsearchjavapop.ui.details;

import com.desafio.githubsearchjavapop.model.PullDetail;

import java.util.List;

public interface DetailsContract {
    public interface View {
        void showGithubRepositories(List<PullDetail> pullDetails);
        void showLoading();
        void hideLoading();
        void showError();
    }

    public interface Presenter {
        void onInit(String login, String repoName);

    }
}
