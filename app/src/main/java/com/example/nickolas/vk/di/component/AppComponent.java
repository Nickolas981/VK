package com.example.nickolas.vk.di.component;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.nickolas.vk.di.module.ApiModule;
import com.example.nickolas.vk.di.module.AppModule;

import java.util.concurrent.Executor;

import javax.inject.Singleton;

import dagger.Component;



@Singleton
@Component(modules = {
        AppModule.class,
        ApiModule.class
})

public interface AppComponent {
    Context context();

    SharedPreferences preferences();

    Executor executor();
}
