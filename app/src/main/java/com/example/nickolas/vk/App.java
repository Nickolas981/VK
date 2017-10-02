package com.example.nickolas.vk;

import android.app.Application;
import android.widget.Toast;

import com.example.nickolas.vk.di.component.AppComponent;
import com.example.nickolas.vk.di.component.DaggerAppComponent;
import com.example.nickolas.vk.di.module.ApiModule;
import com.example.nickolas.vk.di.module.AppModule;
import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKAccessTokenTracker;
import com.vk.sdk.VKSdk;

public class App extends Application {

    VKAccessTokenTracker vkAccessTokenTracker = new VKAccessTokenTracker() {
        @Override
        public void onVKAccessTokenChanged(VKAccessToken oldToken, VKAccessToken newToken) {
            if (newToken == null) {
                Toast.makeText(App.this, "Inavalid tokken", Toast.LENGTH_SHORT).show();
            }
        }
    };
    private AppComponent appComponent;

    public App() {
        super();

        appComponent = DaggerAppComponent.builder()
                .apiModule(new ApiModule())
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent appComponent() {
        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        vkAccessTokenTracker.startTracking();
        VKSdk.initialize(this);
    }
}
