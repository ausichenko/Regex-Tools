package com.ausichenko.regextools.fragments;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ausichenko.regextools.R;

public class PatternsFragment extends Fragment {

    public PatternsFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_patterns, container, false);

        FloatingActionButton fab = (FloatingActionButton)
                fragmentView.findViewById(R.id.floatingActionButton);

        fab.setOnClickListener(v -> {
            //
        });

        return fragmentView;
    }
}
