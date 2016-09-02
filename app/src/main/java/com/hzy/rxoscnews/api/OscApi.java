package com.hzy.rxoscnews.api;

import com.hzy.rxoscnews.bean.NewsEntry;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by huzongrao on 16-9-1.
 */
public interface OscApi {

    @GET("action/api/news_list")
    Observable<NewsEntry> getNews(
            @Query("catalog") int catalog,
            @Query("pageIndex") int pageIndex,
            @Query("pageSize") int pageSize
    );
}