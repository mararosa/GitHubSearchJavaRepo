package com.desafio.githubsearchjavapop.utils;

public interface Callback<T> {
    void onCompleted(T data);
    void onError();
}
