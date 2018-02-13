package com.example.ckpenep.remindme.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ckpenep.remindme.R;

public class ArchiveFragment extends AbstractTabFragment {

    public static ArchiveFragment newInstance(Context context) {
        ArchiveFragment fragment = new ArchiveFragment();
        fragment.setContext(context);
        fragment.setTitle(context.getString(R.string.menu_item_archive));
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_archive, container, false);
        return view;
    }

    public void setContext(Context context) {
        mContext = context;
    }
}
