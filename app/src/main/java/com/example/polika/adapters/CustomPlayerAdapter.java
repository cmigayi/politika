package com.example.polika.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.polika.data.Player;

import java.util.List;

public class CustomPlayerAdapter extends RecyclerView.Adapter<CustomPlayerAdapter.ViewHolder> {
    final static String mCustomPlayerAdapter = "CustomPlayerAdapter";
    Context context;
    List<Player> playerList;
    OnPlayerListener onPlayerListener;
    LayoutInflater layoutInflater;

    public CustomPlayerAdapter(Context context, List<Player> playerList, OnPlayerListener onPlayerListener) {
        this.context = context;
        this.playerList = playerList;
        this.onPlayerListener = onPlayerListener;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public CustomPlayerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomPlayerAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return playerList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        OnPlayerListener onPlayerListener;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        @Override
        public void onClick(View v) {
            onPlayerListener.onPlayerListenerClick(getAdapterPosition());
        }
    }

    public interface OnPlayerListener{
        void onPlayerListenerClick(int position);
    }
}
