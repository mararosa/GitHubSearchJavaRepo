package com.desafio.githubsearchjavapop.ui.main;

import com.desafio.githubsearchjavapop.data.GithubRepository;
import com.desafio.githubsearchjavapop.model.RepositoryDetail;
import com.desafio.githubsearchjavapop.utils.Callback;

import java.util.List;

public class MainPresenter implements MainContract.Presenter{

    private MainContract.View view;
    private GithubRepository mGithubRepository;

    public MainPresenter(MainContract.View view, GithubRepository githubRepository) {
        this.view = view;
        mGithubRepository = githubRepository;
    }

    @Override
    public void onInit() {
        loadGithubRepository();
    }

    @Override
    public void onItemClicked(RepositoryDetail repositoryDetail) {
        if (repositoryDetail != null) {
            view.openRepositoryDetailScreen(repositoryDetail);
        }
    }

    private void loadGithubRepository(){
        view.showLoading();
        mGithubRepository.getRepositories(new Callback<List<RepositoryDetail>>() {
            @Override
            public void onCompleted(List<RepositoryDetail> data) {
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
