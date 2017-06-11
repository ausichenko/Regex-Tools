package com.ausichenko.regextools.fragments;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ausichenko.regextools.R;
import com.ausichenko.regextools.database.AppDatabase;
import com.ausichenko.regextools.database.DatabaseCreator;
import com.ausichenko.regextools.database.Pattern;

import java.util.List;

public class PatternsFragment extends Fragment {

    private AppDatabase mDatabase;

    public PatternsFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_patterns, container, false);

        mDatabase = DatabaseCreator.getInstance(getContext()).getDatabase();

        FloatingActionButton fab = (FloatingActionButton)
                fragmentView.findViewById(R.id.floatingActionButton);

        fab.setOnClickListener(v -> {

            mDatabase.patternDao().insertAll(new Pattern("T", "test"));
            List<Pattern> patterns = mDatabase.patternDao().getAll();
            for (Pattern pattern : patterns) {
                Log.d("PatternFragment",
                        "Pattern = " + pattern.getName() + ":" + pattern.getPattern());
            }
        });

        return fragmentView;
    }
}
