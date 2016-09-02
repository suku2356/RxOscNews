package com.hzy.rxoscnews.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * Created by huzongrao on 16-9-1.
 */
public class LoadMoreRecyclerView extends RecyclerView {

    private PageScrollListener mScrollListener;
    private OnLoadMoreListener mListener;
    private boolean mIsLoading;

    public LoadMoreRecyclerView(Context context) {
        super(context);
    }

    public LoadMoreRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LoadMoreRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init(){
        mScrollListener = new PageScrollListener();
        addOnScrollListener(mScrollListener);
    }

    public boolean ismIsLoading() {
        return mIsLoading;
    }

    public void setLoading(boolean isLoading) {
        this.mIsLoading = isLoading;
    }

    public void removeAutoScroller() {
        removeOnScrollListener(mScrollListener);
    }

    private class PageScrollListener extends OnScrollListener {
        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            if (getLayoutManager() instanceof LinearLayoutManager) {
                int lastVisiblePos = ((LinearLayoutManager) getLayoutManager()).findLastVisibleItemPosition();
                int itemCount = getAdapter().getItemCount();
                if (mListener != null && !mIsLoading && lastVisiblePos > itemCount - 2 && dy > 0) {
                    mListener.onLoadMore();
                    mIsLoading = true;
                }
            }
        }
    }

    public void setOnLoadMoreListener(OnLoadMoreListener listener) {
        mListener = listener;
    }

    public interface OnLoadMoreListener {
        /**
         * Called when a swipe gesture triggers a load.
         */
        void onLoadMore();
    }
}
