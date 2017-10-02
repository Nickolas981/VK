package com.example.nickolas.vk.di.component;

import com.example.nickolas.vk.models.remote.IDialogsDataSource;

import retrofit2.Retrofit;


public interface ApiComponent {
    Retrofit retrofit();

    IDialogsDataSource dialogsDataSource();
}
