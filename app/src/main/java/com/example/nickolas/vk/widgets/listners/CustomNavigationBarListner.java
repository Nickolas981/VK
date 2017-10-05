package com.example.nickolas.vk.widgets.listners;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import com.example.nickolas.vk.R;
import com.example.nickolas.vk.fragments.DialogFragment;
import com.example.nickolas.vk.fragments.FeedFragment;
import com.example.nickolas.vk.fragments.MusicFragment;

public class CustomNavigationBarListner implements BottomNavigationView.OnNavigationItemSelectedListener {


    Fragment currentFragment;
    int id;
    private FragmentTransaction fragT;
    private Activity activity;
    private FeedFragment feedFragment;
    private MusicFragment musicFragment;
    private DialogFragment dialogFragment;
    private Bool dialogInit;
    private Bool feedInit;
    private Bool musicInit;


    public CustomNavigationBarListner(Activity activity, FeedFragment feedFragment, MusicFragment musicFragment, DialogFragment dialogFragment, int id) {
        this.activity = activity;
        this.feedFragment = feedFragment;
        this.musicFragment = musicFragment;
        this.dialogFragment = dialogFragment;
        this.id = id;
        dialogInit = new Bool();
        feedInit = new Bool();
        musicInit = new Bool();

//        fragT.add(musicFragment, musicFragment.getTag()).add(feedFragment, feedFragment.getTag())
//                .add(dialogFragment, dialogFragment.getTag());
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        fragT = activity.getFragmentManager().beginTransaction();
        switch (item.getItemId()) {
            case R.id.navigation_music:
                changeFragment(musicInit, musicFragment);
//                fragT.replace(id, musicFragment, musicFragment.getTag());
//                fragT.commit();
                return true;
            case R.id.navigation_feed:
                changeFragment(feedInit, feedFragment);
//                fragT.replace(id, feedFragment, feedFragment.getTag());
//                fragT.commit();
                return true;
            case R.id.navigation_messages:
                changeFragment(dialogInit, dialogFragment);
//                fragT.replace(id, dialogFragment, dialogFragment.getTag());
//                fragT.commit();
                return true;
        }
        return false;
    }

    private void changeFragment(Bool init, android.app.Fragment fragment) {
        if (!init.b) {
            fragT.add(id, fragment).commit();
            init.b = true;
        } else {
            fragT.hide(currentFragment).show(fragment).commit();
        }
        currentFragment = fragment;
    }

    private class Bool {
        public boolean b;
    }

}
