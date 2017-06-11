package com.ausichenko.regextools.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.ausichenko.regextools.R;

public class PatternEditorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pattern_editor);

        getSupportActionBar().setTitle(R.string.add_pattern);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.pattern_editor_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save:
                savePattern();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void savePattern() {
        Toast.makeText(this, "OK", Toast.LENGTH_SHORT).show();
        finish();
    }
}
