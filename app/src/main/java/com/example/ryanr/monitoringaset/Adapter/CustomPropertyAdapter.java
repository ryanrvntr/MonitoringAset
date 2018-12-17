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
import com.example.ryanr.monitoringaset.DetailPropertyActivity;
import com.example.ryanr.monitoringaset.Model.PropertyModel;
import com.example.ryanr.monitoringaset.R;

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
        View view;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.list_property_view,parent,false);
        final ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, DetailPropertyActivity.class);
                i.putExtra("luas",propertyModels.get(viewHolder.getAdapterPosition()).getLuas());
                i.putExtra("harga",propertyModels.get(viewHolder.getAdapterPosition()).getHarga());
                i.putExtra("no",propertyModels.get(viewHolder.getAdapterPosition()).getNo_sertifikat());
                i.putExtra("lokasi",propertyModels.get(viewHolder.getAdapterPosition()).getLokasi());
                i.putExtra("keterangan",propertyModels.get(viewHolder.getAdapterPosition()).getKeterangan());
                i.putExtra("gambar",propertyModels.get(viewHolder.getAdapterPosition()).getGambar());
//                i.putExtra("nama_rayon",propertyModels.get(viewHolder.getAdapterPosition()).getNama_rayon());
                i.putExtra("tanggal",propertyModels.get(viewHolder.getAdapterPosition()).getTanggal());
                mContext.startActivity(i);
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvname.setText("No Sertifikat : "+propertyModels.get(position).getNo_sertifikat());
        holder.tvkabupaten.setText(propertyModels.get(position).getLokasi());
        Glide.with(mContext).load(propertyModels.get(position).getGambar()).into(holder.ivProperty);
    }

    @Override
    public int getItemCount() {
        return propertyModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvname,tvkabupaten;
        ImageView ivProperty;
        CardView cv;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            tvname = itemView.findViewById(R.id.tvProperty);
            tvkabupaten = itemView.findViewById(R.id.tvKabupaten);
            ivProperty = itemView.findViewById(R.id.ivProperty);
            cv = itemView.findViewById(R.id.cv);
        }
    }
}
