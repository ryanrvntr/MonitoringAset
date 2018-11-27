package com.example.ryanr.monitoringaset;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.ryanr.monitoringaset.Adapter.CustomInventoryAdapter;
import com.example.ryanr.monitoringaset.Model.InventoryModel;

import java.util.ArrayList;
import java.util.List;

public class RecyclerInventoryActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;
    private List<InventoryModel> mInventoryModels = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_inventory);
        mRecyclerView = findViewById(R.id.rvInventory);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        dummyData();
        mAdapter = new CustomInventoryAdapter(mInventoryModels,this);
        mRecyclerView.setAdapter(mAdapter);

    }

    private void dummyData() {
        InventoryModel inventoryModel = new InventoryModel("Wowo", "12 september", R.drawable.ic_launcher_foreground);
        mInventoryModels.add(inventoryModel);

        inventoryModel = new InventoryModel("Wiwi", "13 september", R.drawable.ic_launcher_foreground);
        mInventoryModels.add(inventoryModel);

        inventoryModel = new InventoryModel("Wuwu", "14 september", R.drawable.ic_launcher_foreground);
        mInventoryModels.add(inventoryModel);

        inventoryModel = new InventoryModel("Wewe", "15 september", R.drawable.ic_launcher_foreground);
        mInventoryModels.add(inventoryModel);
    }
}
