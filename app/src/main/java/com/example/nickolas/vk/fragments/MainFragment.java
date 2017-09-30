package com.example.nickolas.vk.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nickolas.vk.R;
import com.example.nickolas.vk.widgets.listners.CustomNavigationBarListner;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainFragment extends Fragment {


    private CustomNavigationBarListner listner;
    @BindView(R.id.bottom_navigation_view)
    BottomNavigationView navigationView;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listner = new CustomNavigationBarListner(getActivity()
                , FeedFragment.newInstance(), MusicFragment.newInstance()
                , DialogFragment.newInstance(), R.id.frame);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);
        navigationView.setOnNavigationItemSelectedListener(listner);
        navigationView.setSelectedItemId(R.id.navigation_feed);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


}
