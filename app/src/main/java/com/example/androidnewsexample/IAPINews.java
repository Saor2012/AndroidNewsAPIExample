package com.example.androidnewsexample;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IAPINews {
    @GET("top-headlines")
    Single<NewsEntry> getNews(@Query("country") String country); //, @Query("language") String lang
}
