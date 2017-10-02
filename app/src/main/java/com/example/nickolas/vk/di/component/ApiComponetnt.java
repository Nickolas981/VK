package com.example.nickolas.vk.di.component;

import com.example.nickolas.vk.models.remote.IDialogsDataSource;

import retrofit2.Retrofit;

/**
 * Created by Nickolas on 01.10.2017.
 */

public interface ApiComponetnt {
    Retrofit retrofit();

    IDialogsDataSource dialogsDataSource();
}
