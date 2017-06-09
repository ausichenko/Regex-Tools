package com.ausichenko.regextools;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.ausichenko.regextools.fragments.CheatSheetFragment;
import com.ausichenko.regextools.fragments.MatcherFragment;
import com.ausichenko.regextools.fragments.PatternsFragment;

public class NavigationActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            getSupportActionBar().setTitle(item.getTitle());
            switch (item.getItemId()) {
                case R.id.nav_matcher:
                    changeFragment(new MatcherFragment());
                    return true;
                case R.id.nav_patterns:
                    changeFragment(new PatternsFragment());
                    return true;
                case R.id.nav_sheet:
                    changeFragment(new CheatSheetFragment());
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        // TODO: 09.06.17 fix it
        getSupportActionBar().setTitle(R.string.nav_matcher);
        changeFragment(new MatcherFragment());
    }

    private void changeFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content, fragment)
                .commit();
    }
}
