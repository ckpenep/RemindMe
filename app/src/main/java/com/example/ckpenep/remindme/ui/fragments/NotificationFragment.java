package com.example.ckpenep.remindme.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ckpenep.remindme.R;
import com.example.ckpenep.remindme.adapters.NotificationListAdapter;
import com.example.ckpenep.remindme.helpers.Logs;
import com.example.ckpenep.remindme.models.Note;
import com.example.ckpenep.remindme.models.NoteLab;
import com.example.ckpenep.remindme.utils.WrapContentLinearLayoutManager;

import java.util.List;

public class NotificationFragment extends AbstractTabFragment {

    private NotificationListAdapter mAdapter;
    private TextView emptyNotesList;
    private RecyclerView mNotesRecyclerView;

    public static NotificationFragment newInstance(Context context) {
        NotificationFragment  fragment = new NotificationFragment();
        fragment.setContext(context);
        fragment.setTitle(context.getString(R.string.menu_item_notification));

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_notification, container, false);

        emptyNotesList = (TextView) view.findViewById(R.id.is_empty_NotesList);
        mNotesRecyclerView = (RecyclerView) view.findViewById(R.id.notification_recycler_view);
        mNotesRecyclerView.setLayoutManager(new WrapContentLinearLayoutManager(getActivity()));



        updateUI();

        return view;
    }

    public void setContext(Context context) {
        mContext = context;
    }

    public void updateUI() {

        List<Note> notes = NoteLab.Instance(getActivity()).getNotes();//получение всех преступлений

        try {
            if (mNotesRecyclerView.getAdapter() == null) {
                mAdapter = new NotificationListAdapter(getContext(), notes);
                mNotesRecyclerView.setAdapter(mAdapter);
            } else {
//                mAdapter.setCrimes(crimes);
//                //обновление всех изменившихся позиций
//                if (mItemUpdatedPositions != null) {
//                    for (int position : mItemUpdatedPositions) {
//                        mAdapter.notifyItemChanged(position);
//                    }
//                }
//
//                mItemUpdatedPositions.clear();
            }

            if (notes.size() == 0) {
                emptyNotesList.setVisibility(View.VISIBLE);
            } else {
                emptyNotesList.setVisibility(View.INVISIBLE);
            }
        }
        catch (Exception ex)
        {
            Logs.d(ex.getMessage());
        }
    }
}
