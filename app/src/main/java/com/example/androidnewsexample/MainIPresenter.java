package com.example.androidnewsexample;

public interface MainIPresenter {
    interface View {}
    interface Presenter extends BaseIPresenter<View> {}
}
