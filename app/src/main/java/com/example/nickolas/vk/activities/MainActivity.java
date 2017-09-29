package com.example.nickolas.vk.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.nickolas.vk.R;
import com.example.nickolas.vk.widgets.VerticalViewPager;
import com.example.nickolas.vk.widgets.adapters.PagerAdapter;

public class MainActivity extends AppCompatActivity {

    VerticalViewPager verticalViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        verticalViewPager = (VerticalViewPager) findViewById(R.id.view_pager);
        verticalViewPager.setAdapter(new PagerAdapter(getSupportFragmentManager()));

    }
}
