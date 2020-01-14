package com.example.androidnewsexample;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NewsEntry {
    @SerializedName("status")
    private String status;
    @SerializedName("totalResults")
    private long totalResults;
    @SerializedName("articles")
    private List<Articles> responseArticles = null;

    public class Articles {
        @SerializedName("source")
        private List<Source> responseSource = null;
        @SerializedName("author")
        private String author;
        @SerializedName("title")
        private String title;
        @SerializedName("description")
        private String description;
        @SerializedName("url")
        private String url;
        @SerializedName("urlToImage")
        private String urlToImage;
        @SerializedName("publishedAt")
        private String publishedAt;
        @SerializedName("content")
        private String content;

        public class Source {
            @SerializedName("id")
            private long id;
            @SerializedName("name")
            private String name;

        }
    }

}
