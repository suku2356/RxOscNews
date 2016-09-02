package com.hzy.rxoscnews.ui.activity;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.hzy.rxoscnews.R;
import com.hzy.rxoscnews.ui.fragment.DetailFragment;

public class DetailActivity extends AppCompatActivity {

    public static final String INTENT_EXTRA_NEWS_ID = "intent_extra_news_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        setDetailFragment();
    }

    private void setDetailFragment() {
        if (getIntent().hasExtra(INTENT_EXTRA_NEWS_ID)) {
            DetailFragment mDetailFragment = new DetailFragment();
            mDetailFragment.setmNewsId(getIntent().getIntExtra(INTENT_EXTRA_NEWS_ID, 0));
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.id_detail_content, mDetailFragment);
            transaction.commit();
        }
    }
}
