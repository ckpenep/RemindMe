package com.example.ckpenep.remindme.ui.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import com.example.ckpenep.remindme.R;
import com.example.ckpenep.remindme.adapters.TabPagerFragmentAdapter;
import com.example.ckpenep.remindme.constants.Constants;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private ViewPager mViewPager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppDefault);//устанавливаем тему
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initToolBar();
        initNavigationView();
        initTabs();
    }

    //иниацилизация toolBar
    private void initToolBar() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle(R.string.app_name);

        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.search:
                        Log.d("MENU_SEARCH", "click");
                        return true;
                    default:
                        return false;
                }
            }
        });

        mToolbar.inflateMenu(R.menu.menu);
    }

    private void initNavigationView() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayoout);

        //кнопка бутерброд в toolBar
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.view_navigation_open, R.string.view_navigation_close);
        mDrawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.navigation);

        //переход между табами в АДАПТЕРЕ
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                mDrawerLayout.closeDrawers();

                switch (item.getItemId()) {
                    case R.id.actionNotificationItem:
                        mViewPager.setCurrentItem(Constants.TAB_ONE);
                        break;
                    case R.id.actionFavoriteItem:
                        mViewPager.setCurrentItem(Constants.TAB_TWO);
                        break;
                    case R.id.actionArchiveItem:
                        mViewPager.setCurrentItem(Constants.TAB_THREE);
                        break;
                }

                return true;
            }
        });
    }

    private void initTabs() {

        mViewPager = (ViewPager) findViewById(R.id.view_pager);

        TabPagerFragmentAdapter adapter = new TabPagerFragmentAdapter(this, getSupportFragmentManager());
        mViewPager.setAdapter(adapter);

        TabLayout mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
        mTabLayout.setupWithViewPager(mViewPager);
    }
}
