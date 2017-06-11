package com.ausichenko.regextools.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.ausichenko.regextools.R;
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.navigation_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_pattern:
                addPattern();
                return true;
            case R.id.settings:
                Toast.makeText(this, "Not now.", Toast.LENGTH_SHORT).show();
                //showSettings();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void addPattern() {
        Intent intent = new Intent(this, PatternEditorActivity.class);
        startActivity(intent);
    }

    private void changeFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content, fragment)
                .commit();
    }
}
