package com.example.ryanr.monitoringaset;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailPropertyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_property);

        String luas = getIntent().getStringExtra("luas");
        String harga = getIntent().getStringExtra("harga");
        String no = getIntent().getStringExtra("no");
        String lokasi = getIntent().getStringExtra("lokasi");
        String keterangan = getIntent().getStringExtra("keterangan");
        String gambar = getIntent().getStringExtra("gambar");
        String tanggal = getIntent().getStringExtra("tanggal");

        TextView tvLuas = findViewById(R.id.tvLuas);
        TextView tvHarga = findViewById(R.id.tvHarga);
        TextView tvNo = findViewById(R.id.tvNo);
        TextView tvLokasi = findViewById(R.id.tvLokasi);
        TextView tvKeterangn = findViewById(R.id.tvKeterangan);
        ImageView ivGarmbar = findViewById(R.id.ivProperty);
        TextView tvTanggal = findViewById(R.id.tvTanggal);

        tvLuas.setText(luas);
        tvHarga.setText(harga);
        tvNo.setText(no);
        tvLokasi.setText(lokasi);
        tvKeterangn.setText(keterangan);
        tvTanggal.setText(tanggal);
        Glide.with(getApplicationContext()).load(gambar).into(ivGarmbar);
    }
}
