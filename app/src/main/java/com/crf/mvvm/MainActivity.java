package com.crf.mvvm;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.crf.mvvm.adapter.ArticleListAdapter;
import com.crf.mvvm.databinding.ActivityArticleBinding;
import com.crf.mvvm.model.WxArticle;
import com.crf.mvvm.viewmodel.WxArticleViewModel;

import java.util.List;

/**
 * @author wyd
 * @version 1.0
 * @description
 * @date 2019/4/24 上午9:07
 */
public class MainActivity extends AppCompatActivity implements WxArticleViewModel.DataListener {
    private ActivityArticleBinding binding = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_article);

        WxArticleViewModel viewModel = new WxArticleViewModel(this);
        binding.setViewmodel(viewModel);
    }

    @Override
    public void articleDataChanage(List<WxArticle.DataBean> repoList) {

        ArticleListAdapter adapter = new ArticleListAdapter(this, repoList);
        binding.recycler.setAdapter(adapter);
        binding.recycler.setLayoutManager(new LinearLayoutManager(this));


    }
}
