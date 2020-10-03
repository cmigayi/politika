package com.example.polika.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.polika.R;
import com.example.polika.data.Player;
import com.example.polika.databinding.CustomPlayerRecyclerviewItemBinding;

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
        CustomPlayerRecyclerviewItemBinding binding = DataBindingUtil.inflate(
                layoutInflater, R.layout.custom_player_recyclerview_item, parent, false
        );
        ViewHolder viewHolder = new ViewHolder(binding, onPlayerListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomPlayerAdapter.ViewHolder holder, int position) {
        holder.binding.setPlayer(playerList.get(position));
    }

    @Override
    public int getItemCount() {
        return playerList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        CustomPlayerRecyclerviewItemBinding binding;
        OnPlayerListener onPlayerListener;

        public ViewHolder(CustomPlayerRecyclerviewItemBinding itemView, OnPlayerListener onPlayerListener) {
            super(itemView.getRoot());
            binding = itemView;
            this.onPlayerListener = onPlayerListener;

            binding.getRoot().setOnClickListener(this);
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
