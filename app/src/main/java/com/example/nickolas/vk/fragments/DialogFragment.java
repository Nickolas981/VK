package com.example.nickolas.vk.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.nickolas.vk.App;
import com.example.nickolas.vk.R;
import com.example.nickolas.vk.di.component.AppComponent;
import com.example.nickolas.vk.di.component.DaggerPresentersComponent;
import com.example.nickolas.vk.di.module.PresentersModule;
import com.example.nickolas.vk.models.enteties.Dialog;
import com.example.nickolas.vk.presenters.DialogsPresenter;
import com.example.nickolas.vk.views.DialogsView;
import com.example.nickolas.vk.widgets.adapters.DialogListAdapter;
import com.example.nickolas.vk.widgets.listners.EndlessRecyclerViewScrollListener;
import com.vk.sdk.api.VKApi;
import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;


public class DialogFragment extends Fragment implements DialogsView {

    public EndlessRecyclerViewScrollListener listener;
    public DialogListAdapter dialogListAdapter;
    public int count, offset;
    @Inject
    DialogsPresenter presenter;
    @BindView(R.id.dialog_recycler_view)
    RecyclerView recyclerView;

    public static DialogFragment newInstance() {
        return new DialogFragment();
    }

    public AppComponent getAppComponent() {
        return ((App) getActivity().getApplication()).appComponent();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerPresentersComponent.builder()
                .appComponent(getAppComponent())
                .presentersModule(new PresentersModule())
                .build()
                .inject(this);
        count = 20;
        offset = 0;
        presenter.setView(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_dialog, container, false);
        ButterKnife.bind(this, v);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(v.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        dialogListAdapter = new DialogListAdapter(v.getContext());
        recyclerView.setAdapter(dialogListAdapter);
        final VKRequest request = VKApi.messages().getDialogs(VKParameters.from(VKApiConst.COUNT, 15));
        Toast.makeText(getActivity(), request.toString(), Toast.LENGTH_SHORT).show();
        presenter.getDialogs(offset);
        return v;
    }

    @Override
    public void showDialogs(List<Dialog> dialogs) {
        dialogListAdapter.addDialogs(dialogs);
        dialogListAdapter.notifyDataSetChanged();
    }
}
