package com.example.ryanr.monitoringaset;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.ryanr.monitoringaset.Adapter.CustomPropertyAdapter;
import com.example.ryanr.monitoringaset.Adapter.CustomTransportAdapter;
import com.example.ryanr.monitoringaset.Model.KendaraanModel;
import com.example.ryanr.monitoringaset.Model.PropertyModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class RecyclerTransportActivity extends AppCompatActivity {

    final String JSON_URL = "http://192.168.43.132/warehouse-inventory/rest_kendaraan";
    JsonArrayRequest request;
    RequestQueue requestQueue;
    List<KendaraanModel> kendaraanModels;
    RecyclerView recyclerView;
    CustomTransportAdapter myadapter;

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_transport);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        kendaraanModels = new ArrayList<>();
        recyclerView = findViewById(R.id.rvTransport);
        jsonrequest();
    }

    private void jsonrequest() {
        request = new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                JSONObject jsonObject = null;

                for (int i = 0; i < response.length(); i++) {

                    try {
                        jsonObject = response.getJSONObject(i);
                        KendaraanModel k = new KendaraanModel();
                        k.setGambar(jsonObject.getString("gambar"));
                        k.setHarga(jsonObject.getString("harga"));
                        k.setNama_kendaraan(jsonObject.getString("nama_kendaraan"));
                        k.setPlat(jsonObject.getString("plat"));
                        k.setNama_kondisi(jsonObject.getString("nama_kondisi"));
                        k.setNama_jenis_kendaraan(jsonObject.getString("nama_jenis_kendaraan"));
                        k.setNama_rayon(jsonObject.getString("nama_rayon"));
                        k.setKeterangan(jsonObject.getString("keterangan"));
                        k.setTanggal(jsonObject.getString("tanggal"));

                        kendaraanModels.add(k);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                setuprecyclerview(kendaraanModels);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }

        });
        requestQueue = Volley.newRequestQueue(RecyclerTransportActivity.this);
        requestQueue.add(request);
    }


    private void setuprecyclerview(List<KendaraanModel> kendaraanModels) {
        myadapter = new CustomTransportAdapter( kendaraanModels,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myadapter);
    }

}
