package com.example.ckpenep.remindme.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.ckpenep.remindme.App;
import com.example.ckpenep.remindme.R;
import com.example.ckpenep.remindme.models.Note;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by ckpenep on 07.02.2018.
 */

public class NotificationListAdapter extends RecyclerView.Adapter<NotificationListAdapter.NotificationListHolder> {

    private List<Note> notes;
    private Context context;

    public NotificationListAdapter(Context context, List<Note> notes) {
        this.notes = notes;
        this.context = context;
    }

    @Override
    public NotificationListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notification_item, parent, false);

        return new NotificationListHolder(view);
    }

    @Override
    public void onBindViewHolder(NotificationListHolder holder, int position) {
        Note note = notes.get(position);
        holder.bindNotification(note, position);
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public static class NotificationListHolder extends RecyclerView.ViewHolder
    {
        Note mNote;
        CardView mCardView;
        TextView mTitle, mTime, mDate, checkStatus;
        Button statusNote;

        public NotificationListHolder(View itemView) {
            super(itemView);

            mCardView = (CardView) itemView.findViewById(R.id.cardView);
            mTitle = (TextView) itemView.findViewById(R.id.titleTextView);
            mTime = (TextView) itemView.findViewById(R.id.timeTextView);
            mDate = (TextView) itemView.findViewById(R.id.dateTextView);
            checkStatus = (TextView) itemView.findViewById(R.id.checkTextView);
            statusNote = (Button) itemView.findViewById(R.id.status_button);
        }

        public void bindNotification(Note note, int position) {
            mNote = note;

            mTitle.setText(mNote.mTitle);

            String fDate = new SimpleDateFormat("dd/MM/yyyy").format(mNote.createDate); // 08/02/2018
            mDate.setText(fDate);

            String fTime = new SimpleDateFormat("kk:mm").format(mNote.createDate); // 13:35
            mTime.setText(fTime);

            checkStatus.setText("Daily");

            Drawable myIcon;
            if(mNote.isFavorite)
            {
                myIcon  = App.getInstance().getResources().getDrawable( R.mipmap.ic_star_small );
            }
            else
            {
                myIcon  = App.getInstance().getResources().getDrawable( R.mipmap.ic_star_outline );
            }
            statusNote.setBackground(myIcon);
        }
    }
}
