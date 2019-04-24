package com.crf.mvvm.viewmodel;

import android.util.Log;

import com.crf.mvvm.model.WxArticle;
import com.crf.mvvm.network.ApiService;

import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author wyd
 * @description
 * @date 2019/4/24 上午8:19
 */
public class WxArticleViewModel {
    private List<WxArticle.DataBean> mList = null;

    private DataListener dataListener = null;

    public WxArticleViewModel(DataListener dataListener) {
        this.dataListener = dataListener;
        loadHomeData();
    }

    public void loadHomeData() {
        ApiService.Factory.create().getWxArticleList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<WxArticle>() {
                    @Override
                    public void onCompleted() {
                        if (mList == null || dataListener == null) {
                            return;
                        }
                        dataListener.articleDataChanage(mList);
                    }

                    @Override
                    public void onError(Throwable e) {
                        //TODO 错误处理
                        Log.e("Main", "onError: "+e.getMessage() );

                    }

                    @Override
                    public void onNext(WxArticle wxArticle) {
                        if (wxArticle == null) {
                            return;
                        }
                        mList = wxArticle.data;

                    }
                });
    }

    public interface DataListener {
        /**
         * 数据更新
         *
         * @param dataBeans
         */
        void articleDataChanage(List<WxArticle.DataBean> dataBeans);
    }


}
