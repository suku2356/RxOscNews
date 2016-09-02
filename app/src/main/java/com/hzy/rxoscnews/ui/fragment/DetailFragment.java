package com.hzy.rxoscnews.ui.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.hzy.rxoscnews.R;
import com.hzy.rxoscnews.api.OscService;
import com.hzy.rxoscnews.bean.ApiEntry;
import com.hzy.rxoscnews.bean.ResultDetail;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by huzongrao on 16-9-2.
 */
public class DetailFragment extends Fragment
        implements SwipeRefreshLayout.OnRefreshListener {

    private int mNewsId;
    @Bind(R.id.id_detail_swip_refresh)
    SwipeRefreshLayout mDetailSwipeRefresh;

    @Bind(R.id.id_detail_webview)
    WebView mDetailWebView;

    public void setmNewsId(int mNewsId) {
        this.mNewsId = mNewsId;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_detail, container, false);
        ButterKnife.bind(this, root);
        return root;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mDetailSwipeRefresh.setOnRefreshListener(this);
        setWebView();
        loadData();
    }

    private void setWebView() {
        mDetailWebView.setClickable(false);
        mDetailWebView.setFocusable(false);
        mDetailWebView.setHorizontalScrollBarEnabled(false);
        WebSettings settings = mDetailWebView.getSettings();
        settings.setSupportZoom(false);
        settings.setBuiltInZoomControls(false);
        settings.setDisplayZoomControls(false);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    private void loadData() {
        if (mNewsId <= 0) {
            return;
        }
        OscService.create().getNewsDetail(mNewsId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onLoadSucceed,
                        this::onLoadFail);
    }

    private void onLoadSucceed(ApiEntry<ResultDetail> detailEntry) {
        mDetailSwipeRefresh.setRefreshing(false);
        String body = detailEntry.getResult().getBody();
        mDetailWebView.loadData(structHtml(body), "text/html; charset=UTF-8", null);
    }

    private void onLoadFail(Throwable error) {
        mDetailSwipeRefresh.setRefreshing(false);
    }

    @Override
    public void onRefresh() {
        loadData();
    }

    private String structHtml(String oriStr) {
        return "<html><head></head><body><style>img{width:100% !important; height:auto}</style>"
                + oriStr + "</body></html>";
    }
}
