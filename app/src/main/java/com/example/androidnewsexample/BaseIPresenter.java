package com.example.androidnewsexample;

public interface BaseIPresenter<V> {
    void startView(V view);
    void stopView();
}
