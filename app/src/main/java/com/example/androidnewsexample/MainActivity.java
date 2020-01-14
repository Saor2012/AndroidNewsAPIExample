package com.example.androidnewsexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telecom.ConnectionService;

import com.example.androidnewsexample.databinding.ActivityMainBinding;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends BaseActivity<ActivityMainBinding> implements MainIPresenter.View {
    private MainIPresenter.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        presenter = new MainPresenter();
        getBinding().setEvent(presenter);
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(Constants.BASE_URL)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                if (response.isSuccessful()) {
                    final String myResponse = response.body().string();
                    MainActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                        }
                    });
                }
            }
        });
    }

    @Override
    protected void onStartView() {
        presenter.startView(this);
    }

    @Override
    protected void onDestroyView() {
        if (presenter != null) presenter.stopView();
        presenter = null;

    }

    @Override
    protected BaseIPresenter getPresenter() {
        return presenter;
    }
}
