package com.example.nickolas.vk.widgets.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nickolas.vk.R;
import com.example.nickolas.vk.models.enteties.Dialog;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;


public class DialogListAdapter extends RecyclerView.Adapter<DialogListAdapter.ViewHolder> {

    private Context context;
    private List<Dialog> dialogs;

    public DialogListAdapter(Context context) {
        dialogs = new ArrayList<>();
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.dialog_item_view, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    public void addDialogs(List<Dialog> dialogs) {
        if (dialogs != null) this.dialogs.addAll(dialogs);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 20;
    }


    protected static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.dialogAvatarImage)
        CircleImageView imageView;
        @BindView(R.id.user_name)
        TextView textView;
        @BindView(R.id.last_message)
        TextView lastMessage;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
