package com.desafio.githubsearchjavapop.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PullRequestDetail {
    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("body")
    @Expose
    private String body;

    @SerializedName("created_at")
    @Expose
    private String created_at;

    @SerializedName("user")
    @Expose
    private User user;


    public PullRequestDetail(String title, String body, String created_at, User user, String avatarUrl) {
        this.title = title;
        this.body = body;
        this.created_at = created_at;
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
