package com.ausichenko.regextools.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.ausichenko.regextools.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherFragment extends Fragment {

    private EditText mRegexEditView;
    private EditText mTextEditText;
    private TextView mCountTextView;
    private TextView mMatcherTextView;

    public MatcherFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_matcher, container, false);

        initViews(fragmentView);
        initWatcher();

        return fragmentView;
    }

    private void initViews(View fragmentView) {
        mRegexEditView = (EditText) fragmentView.findViewById(R.id.regexEditText);
        mTextEditText = (EditText) fragmentView.findViewById(R.id.textEditText);
        mCountTextView = (TextView) fragmentView.findViewById(R.id.countTextView);
        mMatcherTextView = (TextView) fragmentView.findViewById(R.id.matcherTextView);
    }

    private void initWatcher() {
        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                updateMatches();
            }
        };

        mRegexEditView.addTextChangedListener(textWatcher);
        mTextEditText.addTextChangedListener(textWatcher);
    }

    private void updateMatches() {
        String text = mTextEditText.getText().toString();
        String regex = mRegexEditView.getText().toString();

        SpannableStringBuilder stringBuilder = new SpannableStringBuilder(text);
        Matcher matcher = Pattern.compile(regex).matcher(text);
        int count = 0;
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();

            ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.RED);
            stringBuilder.setSpan(colorSpan, start, end, Spannable.SPAN_INCLUSIVE_INCLUSIVE);

            count++;
        }
        mCountTextView.setText(getString(R.string.found_matches, count));
        mMatcherTextView.setText(stringBuilder);
    }

}
