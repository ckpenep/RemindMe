package com.example.ckpenep.remindme.ui.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.ckpenep.remindme.R;
import com.example.ckpenep.remindme.ui.fragments.TaskListFragment;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        setTheme(R.style.AppDefault);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragmentContainer);

        if (fragment == null)
        {
            fragment = createFragment();
            fm.beginTransaction()
                    .add(R.id.fragmentContainer, fragment)
                    .commit();
        }

        initToolBar();
    }

    private void initToolBar() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle(R.string.app_name);

        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return false;
            }
        });

        mToolbar.inflateMenu(R.menu.menu);
    }

    private Fragment createFragment() {
        return new TaskListFragment();
    }
}
