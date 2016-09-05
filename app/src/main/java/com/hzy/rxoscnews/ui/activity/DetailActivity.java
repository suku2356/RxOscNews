package com.hzy.rxoscnews.ui.activity;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.hzy.rxoscnews.R;
import com.hzy.rxoscnews.ui.fragment.DetailFragment;

public class DetailActivity extends AppCompatActivity {

    public static final String INTENT_EXTRA_NEWS_ID = "intent_extra_news_id";
    public static final String INTENT_EXTRA_NEWS_TITLE = "intent_extra_news_title";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        setDetailFragment();
        setToolBar();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void setToolBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowHomeEnabled(false);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
            if (getIntent().hasExtra(INTENT_EXTRA_NEWS_TITLE)) {
                actionBar.setTitle(getIntent().getStringExtra(INTENT_EXTRA_NEWS_TITLE));
            }
        }
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
