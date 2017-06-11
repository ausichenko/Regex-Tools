package com.ausichenko.regextools;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.ausichenko.regextools.fragments.CheatSheetFragment;
import com.ausichenko.regextools.fragments.MatcherFragment;
import com.ausichenko.regextools.fragments.PatternsFragment;

public class NavigationActivity extends AppCompatActivity {

    private MatcherFragment mMatcherFragment;
    private PatternsFragment mPatternsFragment;
    private CheatSheetFragment mCheatSheetFragment;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = item -> {
                getSupportActionBar().setTitle(item.getTitle());
                switch (item.getItemId()) {
                    case R.id.nav_matcher:
                        changeFragment(mMatcherFragment);
                        return true;
                    case R.id.nav_patterns:
                        changeFragment(mPatternsFragment);
                        return true;
                    case R.id.nav_sheet:
                        changeFragment(mCheatSheetFragment);
                        return true;
                }
                return false;
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        mMatcherFragment = new MatcherFragment();
        mPatternsFragment = new PatternsFragment();
        mCheatSheetFragment = new CheatSheetFragment();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        getSupportActionBar().setTitle(navigation.getMenu().getItem(0).getTitle());
        changeFragment(mMatcherFragment);
    }

    private void changeFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content, fragment)
                .commit();
    }
}
