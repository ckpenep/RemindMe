package com.example.ckpenep.remindme.ui.fragments;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Created by ckpenep on 05.02.2018.
 */

public abstract class AbstractTabFragment extends Fragment {

    protected Context mContext;
    protected View view;
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
