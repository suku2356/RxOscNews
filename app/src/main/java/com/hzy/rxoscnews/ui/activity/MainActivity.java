package com.hzy.rxoscnews.ui.activity;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.hzy.rxoscnews.R;
import com.hzy.rxoscnews.ui.fragment.MainFragment;
import com.hzy.rxoscnews.ui.fragment.SettingsFragment;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        addFragments();
    }

    private void addFragments() {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.id_fragment_main, new MainFragment());
        transaction.replace(R.id.id_fragment_settings, new SettingsFragment());
        transaction.commit();
    }
}
