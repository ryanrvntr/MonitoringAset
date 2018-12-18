package com.example.ryanr.monitoringaset;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.ryanr.monitoringaset.Adapter.CustomInventoryAdapter;
import com.example.ryanr.monitoringaset.Model.InventoryModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class RecyclerInventoryActivity extends AppCompatActivity {
    final String JSON_URL = "http://192.168.1.6/warehouse-inventory/rest_barang";
    JsonArrayRequest request;
    RequestQueue requestQueue;
    List<InventoryModel> inventoryModels;
    RecyclerView recyclerView;
    CustomInventoryAdapter myadapter;


    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_inventory);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        inventoryModels = new ArrayList<>();
        recyclerView = findViewById(R.id.rvInventory);
        jsonrequest();
        //   setuprecyclerview(inventoryModels);

    }

    private void jsonrequest() {
        request = new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                JSONObject jsonObject = null;

                for (int i = 0; i < response.length(); i++) {

                    try {
                        jsonObject = response.getJSONObject(i);
                        InventoryModel inventoryModel = new InventoryModel();
                        inventoryModel.setNama_barang(jsonObject.getString("nama_barang"));
                        inventoryModel.setHarga(jsonObject.getString("harga"));
                        inventoryModel.setNama_jenis_barang(jsonObject.getString("nama_jenis_barang"));
                        inventoryModel.setNama_kondisi(jsonObject.getString("nama_kondisi"));
                        inventoryModel.setKeterangan(jsonObject.getString("keterangan"));
                        inventoryModel.setGambar(jsonObject.getString("gambar"));
                        inventoryModel.setNama_rayon(jsonObject.getString("nama_rayon"));
                        inventoryModel.setTanggal(jsonObject.getString("tanggal"));
                        inventoryModel.setId_barang(jsonObject.getString("id_barang"));
                        inventoryModels.add(inventoryModel);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                setuprecyclerview(inventoryModels);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }

        });
        requestQueue = Volley.newRequestQueue(RecyclerInventoryActivity.this);
        requestQueue.add(request);
    }


    private void setuprecyclerview(List<InventoryModel> inventoryModels) {
        myadapter = new CustomInventoryAdapter(this,inventoryModels);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myadapter);
    }
}
