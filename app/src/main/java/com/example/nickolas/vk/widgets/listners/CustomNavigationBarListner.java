package com.example.nickolas.vk.widgets.listners;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import com.example.nickolas.vk.R;
import com.example.nickolas.vk.fragments.DialogMessage;
import com.example.nickolas.vk.fragments.FeedFragment;
import com.example.nickolas.vk.fragments.MusicFragment;

public class CustomNavigationBarListner implements BottomNavigationView.OnNavigationItemSelectedListener {


    private FragmentTransaction fragT;
    private Activity activity;
    private FeedFragment feedFragment;
    private MusicFragment musicFragment;
    private DialogMessage dialogMessage;
    int id;

    public CustomNavigationBarListner(Activity activity, FeedFragment feedFragment, MusicFragment musicFragment, DialogMessage dialogMessage, int id) {
        this.activity = activity;
        this.feedFragment = feedFragment;
        this.musicFragment = musicFragment;
        this.dialogMessage = dialogMessage;
        this.id = id;
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        fragT = activity.getFragmentManager().beginTransaction();
        switch (item.getItemId()) {
            case R.id.navigation_music:
                fragT.replace(id, musicFragment);
                fragT.commit();
                return true;
            case R.id.navigation_feed:
                fragT.replace(id, feedFragment);
                fragT.commit();
                return true;
            case R.id.navigation_messages:
                fragT.replace(id, dialogMessage);
                fragT.commit();
                return true;
        }
        return false;
    }
}
