package com.desafio.githubsearchjavapop.data;

import com.desafio.githubsearchjavapop.model.RepositoryDetail;
import com.desafio.githubsearchjavapop.utils.Callback;

import java.util.List;

public interface GithubRepository {
    void getRepositories(Callback<List<RepositoryDetail>> callback);
    void getPullRequest(String login, String repoName, Callback<List<PullRequestDetail>> callback);
}
