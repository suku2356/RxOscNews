package com.hzy.rxoscnews.api;

import com.hzy.rxoscnews.bean.ApiEntry;
import com.hzy.rxoscnews.bean.ResultDetail;
import com.hzy.rxoscnews.bean.ResultNews;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by huzongrao on 16-9-1.
 */
public interface OscApi {

    @GET("news")
    Observable<ApiEntry<ResultNews>> getNewsList(
            @Query("pageToken") String pageToken
    );

    @GET("news")
    Observable<ApiEntry<ResultDetail>> getNewsDetail(
            @Query("id") int newsId
    );
}