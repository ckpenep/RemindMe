package com.example.ckpenep.remindme.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.ckpenep.remindme.R;

/**
 * Created by ckpenep on 03.02.2018.
 */

public class TaskListFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);//указываем на то, что CrimeListFragment должен получать обратные вызовы меню
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_task_list, container, false);

        return view;
    }

    //СОЗДАНИЕ МЕНЮ
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu, menu);

    }

    //ВЫБОР МЕНЮ ПОЛЬЗОВАТЕЛЕМ
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.search:
                Log.d("MENU_SEARCH", "click");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
