package com.hzy.rxoscnews.api;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 * Created by huzongrao on 16-9-1.
 */
public class OscService {
    public static final String BASE_OSC_URL = "http://www.oschina.net/";

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_OSC_URL)
            .addConverterFactory(SimpleXmlConverterFactory.createNonStrict())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .build();

    private OscService() {
    }

    public static OscApi create() {
        return retrofit.create(OscApi.class);
    }
}
