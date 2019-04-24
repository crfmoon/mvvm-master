package com.crf.mvvm.viewmodel;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.crf.mvvm.model.WxArticle;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * @author wyd
 * @description
 * @date 2019/4/24 上午8:19
 */
public class ItemWxArticleViewModel {
    private List<WxArticle.DataBean> mList = null;
    private WxArticle.DataBean dataBean = null;
    private static Context mContext = null;


    public ItemWxArticleViewModel(Context context, WxArticle.DataBean dataBean) {
        ItemWxArticleViewModel.mContext = context;
        this.dataBean = dataBean;
    }

    public void onItemClick(View view) {
        Toast.makeText(mContext, "点了我~~~", Toast.LENGTH_SHORT).show();
    }


    @BindingAdapter({"imagePath"})
    public static void setImagePath(ImageView image, String url) {
        if (!TextUtils.isEmpty(url)) {
            Picasso.with(mContext).load(url).into(image);
        }
    }

    public void setData(WxArticle.DataBean dataBean) {
        this.dataBean = dataBean;
    }

    public String getTitle() {
        return dataBean.title;
    }

    public String getImagePath() {
        return dataBean.imagePath;
    }


}
