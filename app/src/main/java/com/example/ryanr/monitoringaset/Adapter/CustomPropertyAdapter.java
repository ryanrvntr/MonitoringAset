package com.example.ryanr.monitoringaset.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.ryanr.monitoringaset.Model.PropertyModel;

import java.util.List;

public class CustomPropertyAdapter extends RecyclerView.Adapter<CustomPropertyAdapter.ViewHolder> {
    private List<PropertyModel> propertyModels;
    private Context mContext;

    public CustomPropertyAdapter() {
    }

    public CustomPropertyAdapter(List<PropertyModel> propertyModels, Context mContext) {
        this.propertyModels = propertyModels;
        this.mContext = mContext;
    }

    @NonNull

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
