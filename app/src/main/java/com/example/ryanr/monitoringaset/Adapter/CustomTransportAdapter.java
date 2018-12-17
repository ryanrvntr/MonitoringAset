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
import com.example.ryanr.monitoringaset.DetailTransportActivity;
import com.example.ryanr.monitoringaset.Model.KendaraanModel;
import com.example.ryanr.monitoringaset.R;

import java.util.List;

public class CustomTransportAdapter extends RecyclerView.Adapter<CustomTransportAdapter.ViewHolder> {
    List<KendaraanModel> kendaraanModels;
    Context context;


    public CustomTransportAdapter(List<KendaraanModel> kendaraanModels, Context context) {
        this.kendaraanModels = kendaraanModels;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, final int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.list_transport,parent,false);
        final ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, DetailTransportActivity.class);
                i.putExtra("nama",kendaraanModels.get(viewHolder.getAdapterPosition()).getNama_kendaraan());
                i.putExtra("harga",kendaraanModels.get(viewHolder.getAdapterPosition()).getHarga());
                i.putExtra("nama_jenis",kendaraanModels.get(viewHolder.getAdapterPosition()).getNama_jenis_kendaraan());
                i.putExtra("nama_kondisi",kendaraanModels.get(viewHolder.getAdapterPosition()).getNama_kondisi());
                i.putExtra("keterangan",kendaraanModels.get(viewHolder.getAdapterPosition()).getKeterangan());
                i.putExtra("gambar",kendaraanModels.get(viewHolder.getAdapterPosition()).getGambar());
                i.putExtra("nama_rayon",kendaraanModels.get(viewHolder.getAdapterPosition()).getNama_rayon());
                i.putExtra("tanggal",kendaraanModels.get(viewHolder.getAdapterPosition()).getTanggal());
                i.putExtra("plat",kendaraanModels.get(viewHolder.getAdapterPosition()).getPlat());
                context.startActivity(i);
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvName.setText(kendaraanModels.get(position).getNama_kendaraan());
        holder.tvNoPlat.setText(kendaraanModels.get(position).getPlat());
        Glide.with(context).load(kendaraanModels.get(position).getGambar()).into(holder.imgTransport);
    }

    @Override
    public int getItemCount() {
        return kendaraanModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName,tvNoPlat;
        ImageView imgTransport;
        CardView cv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName= itemView.findViewById(R.id.tvTransport);
            tvNoPlat= itemView.findViewById(R.id.tvNoPlat);
            imgTransport= itemView.findViewById(R.id.ivTransport);
            cv = itemView.findViewById(R.id.cv);
        }
    }
}
