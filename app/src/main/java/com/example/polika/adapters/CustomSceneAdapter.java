package com.example.polika.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.polika.R;
import com.example.polika.data.Scene;
import com.example.polika.databinding.CustomSceneRecyclerviewItemBinding;

import java.util.List;

public class CustomSceneAdapter extends RecyclerView.Adapter<CustomSceneAdapter.ViewHolder> {
    final static String mCustomSceneAdapter = "CustomSceneAdapter";
    Context context;
    List<Scene> sceneList;
    CustomSceneAdapter.OnSceneListener onSceneListener;
    LayoutInflater layoutInflater;

    public CustomSceneAdapter(Context context, List<Scene> sceneList, CustomSceneAdapter.OnSceneListener onSceneListener) {
        this.context = context;
        this.sceneList = sceneList;
        this.onSceneListener = onSceneListener;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public CustomSceneAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CustomSceneRecyclerviewItemBinding binding = DataBindingUtil.inflate(
                layoutInflater, R.layout.custom_scene_recyclerview_item, parent, false
        );
        CustomSceneAdapter.ViewHolder viewHolder = new CustomSceneAdapter.ViewHolder(binding, onSceneListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomSceneAdapter.ViewHolder holder, int position) {
        holder.binding.setScene(sceneList.get(position));
    }

    @Override
    public int getItemCount() {
        return sceneList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        CustomSceneRecyclerviewItemBinding binding;
        CustomSceneAdapter.OnSceneListener onSceneListener;

        public ViewHolder(CustomSceneRecyclerviewItemBinding itemView, CustomSceneAdapter.OnSceneListener onSceneListener) {
            super(itemView.getRoot());
            binding = itemView;
            this.onSceneListener = onSceneListener;

            binding.getRoot().setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onSceneListener.onSceneListenerClick(getAdapterPosition());
        }
    }

    public interface OnSceneListener{
        void onSceneListenerClick(int position);
    }
}
