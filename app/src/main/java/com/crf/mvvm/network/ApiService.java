package com.crf.mvvm.network;

import com.crf.mvvm.model.WxArticle;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import rx.Observable;

/**
 * @author wyd
 * @description
 * @date 2019/4/24 上午8:47
 */
public interface ApiService {
    /**
     * 获取首页列表
     *
     * @return
     */
    @GET("banner/json")
    Observable<WxArticle> getWxArticleList();

    class Factory {
        public static ApiService create() {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://www.wanandroid.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
            return retrofit.create(ApiService.class);
        }

    }

}
