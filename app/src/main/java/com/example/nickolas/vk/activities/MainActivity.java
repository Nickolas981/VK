package com.example.nickolas.vk.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.nickolas.vk.R;
import com.example.nickolas.vk.widgets.VerticalViewPager;
import com.example.nickolas.vk.widgets.adapters.PagerAdapter;
import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKCallback;
import com.vk.sdk.VKScope;
import com.vk.sdk.VKSdk;
import com.vk.sdk.api.VKError;

public class MainActivity extends AppCompatActivity {

    private static final String[] scope = new String[]{
            VKScope.AUDIO, VKScope.MESSAGES, VKScope.WALL, VKScope.FRIENDS
    };
    VerticalViewPager verticalViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        verticalViewPager = (VerticalViewPager) findViewById(R.id.view_pager);
        verticalViewPager.setAdapter(new PagerAdapter(getSupportFragmentManager()));
//        if  (!VKSdk.isLoggedIn()){
        VKSdk.login(this, scope);
//        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (!VKSdk.onActivityResult(requestCode, resultCode, data, new VKCallback<VKAccessToken>() {
            @Override
            public void onResult(VKAccessToken res) {
                Toast.makeText(MainActivity.this, "Okay", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(VKError error) {
                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        })) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
