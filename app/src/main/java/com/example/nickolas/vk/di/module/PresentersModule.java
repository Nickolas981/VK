package com.example.nickolas.vk.di.module;


import com.example.nickolas.vk.di.scopes.Scope;
import com.example.nickolas.vk.di.scopes.Scopes;
import com.example.nickolas.vk.models.remote.IDialogsDataSource;
import com.example.nickolas.vk.presenters.DialogsPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class PresentersModule {


    @Provides
    @Scope(Scopes.VIEW)
    public DialogsPresenter provideDialogsPresenter(IDialogsDataSource dialogsDataSource) {
        return new DialogsPresenter(dialogsDataSource);
    }
}
