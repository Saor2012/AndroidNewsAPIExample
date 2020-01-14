package com.example.androidnewsexample;

import android.app.Application;
import android.graphics.Bitmap;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class App extends Application {
    private static Retrofit retrofit;
    private static OkHttpClient okHttpClient;
    private static Gson gson;

    @Override
    public void onCreate() {
        super.onCreate();

        retrofit = provideRetrofitClient();
    }

    public OkHttpClient provideOkHttpClient() {
        final OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(interceptor);
        }
        builder.connectTimeout(60 * 1000, TimeUnit.MILLISECONDS)
            .readTimeout(60 * 1000, TimeUnit.MILLISECONDS);
        return builder.build();
    }

    static Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return gsonBuilder.setLenient().create();
    }

    static Retrofit provideRetrofitClient() {
        /*OkHttpClient client = null;

        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        }
        assert client != null;
        retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        return retrofit;*/
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.client(okHttpClient).baseUrl(Constants.BASE_URL)
                //.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson));
        return builder.build();
    }

    //public ApiService privideApi(Retrofit restAdapter) {
    //    return restAdapter.create(ApiService.class);
    //}

    //static ApiService provideApiService(Gson gson, OkHTTPClient okHttpClient, SharedPreferencesStorage storage) {
    //    return restAdapter.create(ApiService.class, okHttpClient.class, GsonConverterFactory.create(gson));
    // }

    //
}
