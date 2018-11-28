package com.example.ryanr.monitoringaset.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ryanr.monitoringaset.Model.InventoryModel;
import com.example.ryanr.monitoringaset.R;

import java.util.List;

public class CustomInventoryAdapter extends RecyclerView.Adapter<CustomInventoryAdapter.ViewHolder> {
    private List<InventoryModel> mInventoryModel;
    private Context mContext;

    public CustomInventoryAdapter() {
    }

    public CustomInventoryAdapter(List<InventoryModel> mInventoryModel, Context mContext) {
        this.mInventoryModel = mInventoryModel;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_inventory_view,parent,false);
        return new ViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        InventoryModel inventoryModel = mInventoryModel.get(position);
        holder.tvInven.setText(inventoryModel.getNama());
        holder.tvDate.setText(inventoryModel.getTanggal());
        Glide.with(mContext).load(inventoryModel.getGambar()).into(holder.ivInven);
    }

    @Override
    public int getItemCount() {
        return mInventoryModel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvInven,tvDate;
        ImageView ivInven;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvInven = itemView.findViewById(R.id.tvInventory);
            tvDate = itemView.findViewById(R.id.tvDate);
            ivInven = itemView.findViewById(R.id.ivInventory);
        }
    }
}
