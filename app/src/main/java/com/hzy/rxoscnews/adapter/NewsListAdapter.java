package com.hzy.rxoscnews.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hzy.rxoscnews.R;
import com.hzy.rxoscnews.bean.NewsItem;
import com.hzy.rxoscnews.ui.activity.DetailActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by huzongrao on 16-9-1.
 */
public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.MainItemHolder> {

    private final Context mContext;
    private List<NewsItem> mListItems;
    private long mLastPosi = -1;

    public NewsListAdapter(Context context) {
        mContext = context;
        mListItems = new ArrayList<>();
    }

    public void setItemList(List<NewsItem> mListItems) {
        this.mListItems = mListItems;
        notifyDataSetChanged();
    }

    public void addItemList(List<NewsItem> mListItems) {
        this.mListItems.addAll(mListItems);
        notifyDataSetChanged();
    }

    @Override
    public MainItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main, parent, false);
        return new MainItemHolder(view);
    }

    @Override
    public int getItemCount() {
        return mListItems.size();
    }

    @Override
    public void onBindViewHolder(MainItemHolder holder, int position) {
        NewsItem item = mListItems.get(position);
        holder.textTitle.setText(item.getTitle());
        holder.textContent.setText(item.getBody());
        holder.textTime.setText(item.getPubDate());
        holder.viewFrame.setOnClickListener(view -> {
            Intent intent = new Intent(mContext, DetailActivity.class);
            intent.putExtra(DetailActivity.INTENT_EXTRA_NEWS_ID, item.getId());
            mContext.startActivity(intent);
        });
    }

    class MainItemHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.id_item_card)
        CardView viewCard;

        @Bind(R.id.id_item_frame)
        LinearLayout viewFrame;

        @Bind(R.id.id_item_title)
        TextView textTitle;

        @Bind(R.id.id_item_content)
        TextView textContent;

        @Bind(R.id.id_item_time)
        TextView textTime;

        public MainItemHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
