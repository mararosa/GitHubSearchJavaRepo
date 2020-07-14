package com.desafio.githubsearchjavapop.ui.main;

import com.desafio.githubsearchjavapop.model.RepositoryDetail;

import java.util.List;

public interface MainContract {
    public interface View {
        void showGithubRepositories(List<RepositoryDetail> repositoryDetails);
        void showLoading();
        void hideLoading();

        void showError();

        void openRepositoryDetailScreen(RepositoryDetail repositoryDetail);
    }
    public interface Presenter {

        void onInit();

        void onItemClicked(RepositoryDetail repositoryDetail);
    }
    
}
