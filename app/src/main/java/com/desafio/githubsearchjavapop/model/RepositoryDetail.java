package com.desafio.githubsearchjavapop.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RepositoryDetail {
    @SerializedName("name")
    @Expose
    private String repoName;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("forks_count")
    @Expose
    private String forksCount;

    @SerializedName("stargazers_count")
    @Expose
    private String stargazersCount;

    @SerializedName("owner")
    @Expose
    private Owner owner;

    public RepositoryDetail(String repoName, String description, String forksCount, String stargazersCount, Owner owner) {
        this.repoName = repoName;
        this.description = description;
        this.forksCount = forksCount;
        this.stargazersCount = stargazersCount;
        this.owner = owner;
    }

    public String getRepoName() {
        return repoName;
    }

    public void setRepoName(String repoName) {
        this.repoName = repoName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getForksCount() {
        return forksCount;
    }

    public void setForksCount(String forksCount) {
        this.forksCount = forksCount;
    }

    public String getStargazersCount() {
        return stargazersCount;
    }

    public void setStargazersCount(String stargazersCount) {
        this.stargazersCount = stargazersCount;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
