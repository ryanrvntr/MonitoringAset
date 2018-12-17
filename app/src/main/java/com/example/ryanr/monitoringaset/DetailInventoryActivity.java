package com.example.ryanr.monitoringaset;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailInventoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_inventory);

        String name = getIntent().getStringExtra("nama");
        String harga = getIntent().getStringExtra("harga");
        String jenis = getIntent().getStringExtra("nama_jenis");
        String kondisi = getIntent().getStringExtra("nama_kondisi");
        String keterangan = getIntent().getStringExtra("keterangan");
        String gambar = getIntent().getStringExtra("gambar");
        String rayon = getIntent().getStringExtra("nama_rayon");
        String tanggal = getIntent().getStringExtra("tanggal");

        TextView tvName = findViewById(R.id.tvNama);
        TextView tvHarga = findViewById(R.id.tvHarga);
        TextView tvjenis = findViewById(R.id.tvJenis);
        TextView tvKondisi = findViewById(R.id.tvKondisi);
        TextView tvKeterangn = findViewById(R.id.tvKeterangan);
        ImageView ivGarmbar = findViewById(R.id.ivInventory);
        TextView tvRayon = findViewById(R.id.tvRayon);
        TextView tvTanggal = findViewById(R.id.tvTanggal);

        tvName.setText(name);
        tvHarga.setText(harga);
        tvjenis.setText(jenis);
        tvKondisi.setText(kondisi);
        tvKeterangn.setText(keterangan);
        tvRayon.setText(rayon);
        tvTanggal.setText(tanggal);
        Glide.with(getApplicationContext()).load(gambar).into(ivGarmbar);

    }
}
