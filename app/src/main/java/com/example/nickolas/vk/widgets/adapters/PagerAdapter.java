package com.example.nickolas.vk.widgets.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.nickolas.vk.fragments.MainFragment;
import com.example.nickolas.vk.fragments.MenuFragment;


public class PagerAdapter extends FragmentStatePagerAdapter {


    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0)
            return new MainFragment();
        else if (position == 1)
            return new MenuFragment();
        else
            return null;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
