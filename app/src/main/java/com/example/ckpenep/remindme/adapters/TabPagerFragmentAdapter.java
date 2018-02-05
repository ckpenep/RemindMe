package com.example.ckpenep.remindme.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.ckpenep.remindme.R;
import com.example.ckpenep.remindme.ui.fragments.ArchiveFragment;
import com.example.ckpenep.remindme.ui.fragments.FavoriteFragment;
import com.example.ckpenep.remindme.ui.fragments.InfoFragment;
import com.example.ckpenep.remindme.ui.fragments.NotificationFragment;
import com.example.ckpenep.remindme.ui.fragments.SettingsFragment;

/**
 * Created by ckpenep on 04.02.2018.
 */

public class TabPagerFragmentAdapter extends FragmentPagerAdapter {

    private String[] tabs;

    public TabPagerFragmentAdapter(Context context, FragmentManager fm) {
        super(fm);

        tabs = new String[]{
                context.getResources().getString(R.string.menu_item_notification),
                context.getResources().getString(R.string.menu_item_favorite),
                context.getResources().getString(R.string.menu_item_archive),
        };
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return NotificationFragment.newInstance();
            case 1:
                return FavoriteFragment.newInstance();
            case 2:
                return ArchiveFragment.newInstance();
            case 3:
                return SettingsFragment.newInstance();
            case 4:
                return InfoFragment.newInstance();
        }

        return null;
    }

    @Override
    public int getCount() {
        return tabs.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs[position];
    }
}
