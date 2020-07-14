package com.desafio.githubsearchjavapop.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ItemResponse {
    @SerializedName("items")
    @Expose
    private List<RepositoryDetail> mRepositoryDetails;

    public List<RepositoryDetail> getRepositoryDetails() {
        //for int i = 0; a.length i++
        return mRepositoryDetails;
    }

    public void setRepositoryDetails(List<RepositoryDetail> repositoryDetails) {
        this.mRepositoryDetails = repositoryDetails;
    }
}
