package com.hzy.rxoscnews.ui.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hzy.rxoscnews.R;
import com.hzy.rxoscnews.adapter.NewsListAdapter;
import com.hzy.rxoscnews.api.OscService;
import com.hzy.rxoscnews.bean.NewsEntry;
import com.hzy.rxoscnews.bean.NewsItem;
import com.hzy.rxoscnews.widget.LoadMoreRecyclerView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by huzongrao on 16-9-1.
 */
public class NewsFragment extends Fragment
        implements SwipeRefreshLayout.OnRefreshListener,
        LoadMoreRecyclerView.OnLoadMoreListener {

    private static final int PAGE_SIZE = 20;
    private int mCurPage = 0;

    @Bind(R.id.id_swip_refresh)
    SwipeRefreshLayout mSwipRefresh;

    @Bind(R.id.id_more_recycler)
    LoadMoreRecyclerView mMoreRecycler;
    private NewsListAdapter mMainAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, root);
        return root;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mSwipRefresh.setOnRefreshListener(this);
        mMoreRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        mMoreRecycler.setItemAnimator(new DefaultItemAnimator());
        mMainAdapter = new NewsListAdapter(getActivity());
        mMoreRecycler.setAdapter(mMainAdapter);
        mMoreRecycler.setOnLoadMoreListener(this);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getListData(true);
    }

    @Override
    public void onRefresh() {
        getListData(true);
    }

    @Override
    public void onLoadMore() {
        getListData(false);
    }

    private void getListData(boolean isRefresh) {
        if (isRefresh) {
            mCurPage = 0;
        }
        OscService.create().getNews(0, mCurPage, PAGE_SIZE)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(newsEntry -> onLoadSucceed(newsEntry, isRefresh),
                        error -> onLoadFail(error, isRefresh));
    }

    private void onLoadSucceed(NewsEntry entry, boolean isRefresh) {
        List<NewsItem> items = entry.getNewslist();
        mCurPage++;
        if (isRefresh) {
            mSwipRefresh.setRefreshing(false);
            mMainAdapter.setItemList(items);
        } else {
            mMoreRecycler.setLoading(false);
            mMainAdapter.addItemList(items);
        }
    }

    private void onLoadFail(Throwable error, boolean isRefresh) {
        if (isRefresh) {
            mSwipRefresh.setRefreshing(false);
        } else {
            mMoreRecycler.setLoading(false);
        }
    }
}
