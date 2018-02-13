package com.example.ckpenep.remindme.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.ckpenep.remindme.helpers.Logs;
import com.example.ckpenep.remindme.ui.fragments.AbstractTabFragment;
import com.example.ckpenep.remindme.ui.fragments.ArchiveFragment;
import com.example.ckpenep.remindme.ui.fragments.FavoriteFragment;
import com.example.ckpenep.remindme.ui.fragments.NotificationFragment;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ckpenep on 04.02.2018.
 */

public class TabsFragmentAdapter extends FragmentPagerAdapter {

    private Map<Integer, AbstractTabFragment> tabs;
    private Context mContext;

    public TabsFragmentAdapter(Context context, FragmentManager fm) {
        super(fm);

        this.mContext = context;
        initTabsMap();
    }

    @Override
    public Fragment getItem(int position) {

        Fragment fragment = tabs.get(position);
        Logs.d(tabs.get(position).getTitle());
        return fragment;
    }

    @Override
    public int getCount() {
        return tabs.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs.get(position).getTitle();
    }

    private void initTabsMap() {
        tabs = new HashMap<>();
        tabs.put(0, NotificationFragment.newInstance(mContext));
        tabs.put(1, FavoriteFragment.newInstance(mContext));
        tabs.put(2, ArchiveFragment.newInstance(mContext));
    }
}
