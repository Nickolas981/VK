package com.example.nickolas.vk.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.example.nickolas.vk.App;
import com.example.nickolas.vk.R;
import com.example.nickolas.vk.di.component.AppComponent;
import com.example.nickolas.vk.di.component.DaggerPresentersComponent;
import com.example.nickolas.vk.di.module.PresentersModule;
import com.example.nickolas.vk.models.enteties.Message;
import com.example.nickolas.vk.presenters.DialogPresenter;
import com.example.nickolas.vk.views.DialogView;
import com.example.nickolas.vk.widgets.listners.EndlessRecyclerViewScrollListener;
import com.r0adkll.slidr.Slidr;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class DialogActivity extends AppCompatActivity implements DialogView {

    public EndlessRecyclerViewScrollListener listener;
    public int count = 20,
            offset = 0;
    @Inject
    DialogPresenter presenter;
    @BindView(R.id.dialog_recycler_view)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Slidr.attach(this);
        setContentView(R.layout.activity_dialog_ativity);
        DaggerPresentersComponent.builder()
                .appComponent(getAppComponent())
                .presentersModule(new PresentersModule())
                .build()
                .inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    public AppComponent getAppComponent() {
        return ((App) getApplication()).appComponent();
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void showMessages(List<Message> messages) {

    }
}
