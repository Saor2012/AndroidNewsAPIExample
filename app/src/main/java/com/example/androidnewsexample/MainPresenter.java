package com.example.androidnewsexample;

public class MainPresenter implements MainIPresenter.Presenter {
    private MainIPresenter.View view;

    @Override
    public void startView(MainIPresenter.View view) {
        this.view = view;
    }

    @Override
    public void stopView() {
        if (view != null) view = null;
    }
}
