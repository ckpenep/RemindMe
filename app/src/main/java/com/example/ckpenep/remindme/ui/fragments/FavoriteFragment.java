package com.example.ckpenep.remindme.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ckpenep.remindme.R;

public class FavoriteFragment extends AbstractTabFragment {

    public static FavoriteFragment newInstance(Context context) {
        FavoriteFragment fragment = new FavoriteFragment();
        fragment.setContext(context);
        fragment.setTitle(context.getString(R.string.menu_item_favorite));
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.fragment_favorite, container, false);
        return view;
    }

    public void setContext(Context context) {
        mContext = context;
    }
}
