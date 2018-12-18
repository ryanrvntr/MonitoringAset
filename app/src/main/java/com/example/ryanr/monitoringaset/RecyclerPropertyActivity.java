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
import com.example.ryanr.monitoringaset.Adapter.CustomInventoryAdapter;
import com.example.ryanr.monitoringaset.Adapter.CustomPropertyAdapter;
import com.example.ryanr.monitoringaset.Model.InventoryModel;
import com.example.ryanr.monitoringaset.Model.PropertyModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class RecyclerPropertyActivity extends AppCompatActivity {

    final String JSON_URL = "http://192.168.1.6/warehouse-inventory/rest_properti";
    JsonArrayRequest request;
    RequestQueue requestQueue;
    List<PropertyModel> propertyModels;
    RecyclerView recyclerView;
    CustomPropertyAdapter myadapter;

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_property);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        propertyModels = new ArrayList<>();
        recyclerView = findViewById(R.id.rvProperty);
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
                        PropertyModel propertyModel = new PropertyModel();
                        propertyModel.setGambar(jsonObject.getString("gambar"));
                        propertyModel.setLuas(jsonObject.getString("luas"));
                        propertyModel.setHarga(jsonObject.getString("harga"));
                        propertyModel.setKeterangan(jsonObject.getString("keterangan"));
                        propertyModel.setNo_sertifikat(jsonObject.getString("no_sertifikat"));
                        propertyModel.setLokasi(jsonObject.getString("lokasi"));
                        propertyModel.setTanggal(jsonObject.getString("tanggal"));
                        propertyModels.add(propertyModel);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                setuprecyclerview(propertyModels);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }

        });
        requestQueue = Volley.newRequestQueue(RecyclerPropertyActivity.this);
        requestQueue.add(request);
    }

    private void setuprecyclerview(List<PropertyModel> propertyModels) {
        myadapter = new CustomPropertyAdapter( propertyModels,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myadapter);
    }


}
