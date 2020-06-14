package com.example.andweatherapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {

    List<String> historyInfo;

    public HistoryAdapter(List<String> historyInfo)
    {
        this.historyInfo = historyInfo;
    }

    @NonNull
    @Override
    public HistoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.history_element, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.historyInfo.setText(historyInfo.get(position));
    }

    @Override
    public int getItemCount() {
        return historyInfo.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView historyInfo;
        ImageView icon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            historyInfo = itemView.findViewById(R.id.historyCity);
        }
    }
}
