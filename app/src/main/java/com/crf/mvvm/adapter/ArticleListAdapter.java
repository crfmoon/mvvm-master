package com.crf.mvvm.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.crf.mvvm.R;
import com.crf.mvvm.databinding.ActivityArticleItemBinding;
import com.crf.mvvm.model.WxArticle;
import com.crf.mvvm.viewmodel.ItemWxArticleViewModel;

import java.util.List;

/**
 * @author wyd
 * @version 1.0
 * @description
 * @date 2019/4/24 上午10:42
 */

public class ArticleListAdapter extends RecyclerView.Adapter<ArticleListAdapter.ViewHolder> {

    private Context mContext;

    private List<WxArticle.DataBean> dataBeans;

    public ArticleListAdapter(Context context, List<WxArticle.DataBean> repoList) {
        this.mContext = context;
        this.dataBeans = repoList;
    }

    public void setRepoList(List<WxArticle.DataBean> dataBeans) {
        this.dataBeans = dataBeans;
        notifyDataSetChanged();
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ActivityArticleItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.activity_article_item,parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        WxArticle.DataBean dataBean = dataBeans.get(position);
        holder.bindData(dataBean);

    }

    @Override
    public int getItemCount() {
        return dataBeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ActivityArticleItemBinding binding;

        public ViewHolder(ActivityArticleItemBinding binding) {
            super(binding.ll);
            this.binding = binding;
        }

        public void bindData(WxArticle.DataBean dataBean) {
            if (binding.getViewModel() == null) {
                binding.setViewModel(new ItemWxArticleViewModel(mContext, dataBean));
            } else {
                binding.getViewModel().setData(dataBean);
            }
        }

        private void openUserRepoActivity(String name) {
            /*Intent intent = new Intent(mContext, UserRepoActivity.class) ;
            intent.putExtra("username",name);
            mContext.startActivity(intent);*/
        }
    }
}
