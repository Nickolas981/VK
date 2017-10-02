package com.example.nickolas.vk.di.module;

import com.example.nickolas.vk.Constants;
import com.example.nickolas.vk.api.VkApi;
import com.example.nickolas.vk.models.remote.DialogsDataSource;
import com.example.nickolas.vk.models.remote.IDialogsDataSource;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

@Module
public class ApiModule {

    @Provides
    @Singleton
    public Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(Constants.getBaseUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    public IDialogsDataSource provideDialogsDataSource(Retrofit retrofit){
        return new DialogsDataSource(retrofit.create(VkApi.class));
    }

}
