package com.example.nickolas.vk.di.component;


import com.example.nickolas.vk.di.module.PresentersModule;
import com.example.nickolas.vk.di.scopes.Scope;
import com.example.nickolas.vk.di.scopes.Scopes;
import com.example.nickolas.vk.fragments.DialogFragment;

import dagger.Component;

@Scope(Scopes.VIEW)
@Component(
        modules = {PresentersModule.class},
        dependencies = {AppComponent.class}
)
public interface PresentersComponent {

//    void inject(MusicFragment musicFragment);

//    void inject(FeedFragment feedFragment);

    void inject(DialogFragment dialogFragment);

}
