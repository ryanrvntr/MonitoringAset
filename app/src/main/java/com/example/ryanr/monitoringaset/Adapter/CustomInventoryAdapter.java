package com.example.ryanr.monitoringaset.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ryanr.monitoringaset.DetailInventoryActivity;
import com.example.ryanr.monitoringaset.Model.InventoryModel;
import com.example.ryanr.monitoringaset.R;

import java.util.List;

public class CustomInventoryAdapter extends RecyclerView.Adapter<CustomInventoryAdapter.ViewHolder> {
    private List<InventoryModel> mInventoryModel;
    private Context mContext;


    public CustomInventoryAdapter( Context mContext, List<InventoryModel> mInventoryModel) {
        this.mInventoryModel = mInventoryModel;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.list_inventory_view,parent,false);
        final ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, DetailInventoryActivity.class);
                i.putExtra("nama",mInventoryModel.get(viewHolder.getAdapterPosition()).getNama_barang());
                i.putExtra("harga",mInventoryModel.get(viewHolder.getAdapterPosition()).getHarga());
                i.putExtra("nama_jenis",mInventoryModel.get(viewHolder.getAdapterPosition()).getNama_jenis_barang());
                i.putExtra("nama_kondisi",mInventoryModel.get(viewHolder.getAdapterPosition()).getNama_kondisi());
                i.putExtra("keterangan",mInventoryModel.get(viewHolder.getAdapterPosition()).getKeterangan());
                i.putExtra("gambar",mInventoryModel.get(viewHolder.getAdapterPosition()).getGambar());
                i.putExtra("nama_rayon",mInventoryModel.get(viewHolder.getAdapterPosition()).getNama_rayon());
                i.putExtra("tanggal",mInventoryModel.get(viewHolder.getAdapterPosition()).getTanggal());
                mContext.startActivity(i);
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvInven.setText(mInventoryModel.get(position).getNama_barang());
        holder.tvDate.setText(mInventoryModel.get(position).getTanggal());
        Glide.with(mContext).load(mInventoryModel.get(position).getGambar()).into(holder.ivInven);
    }

    @Override
    public int getItemCount() {
        return mInventoryModel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvInven;
        TextView tvDate;
        ImageView ivInven;
        CardView cv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvInven = itemView.findViewById(R.id.tvInventory);
            tvDate = itemView.findViewById(R.id.tvDate);
            ivInven = itemView.findViewById(R.id.ivInventory);
            cv = itemView.findViewById(R.id.cv);
        }
    }
}
