package com.desafio.githubsearchjavapop.data;

import com.desafio.githubsearchjavapop.model.PullDetail;
import com.desafio.githubsearchjavapop.utils.Callback;

import java.util.List;

public interface GithubPull {
    void getPullRequest(String login, String repoName, Callback<List<PullDetail>> callback);
}
