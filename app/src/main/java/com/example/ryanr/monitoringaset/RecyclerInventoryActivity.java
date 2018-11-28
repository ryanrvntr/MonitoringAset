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
        InventoryModel inventoryModel = new InventoryModel("inven1","merk1","1","lusin","ruang1","ket 1","jenis 1","R.drawable.ic_launcher_background","1 1 2001");
        mInventoryModels.add(inventoryModel);

        inventoryModel = new InventoryModel("inven2","merk2","2","lusin","ruang2","ket 2","jenis 2","R.drawable.ic_launcher_background","2 2 2002");
        mInventoryModels.add(inventoryModel);

        inventoryModel = new InventoryModel("inven3","merk3","3","lusin","ruang3","ket 3","jenis 3","R.drawable.ic_launcher_background","3 3 2003");
        mInventoryModels.add(inventoryModel);

        inventoryModel = new InventoryModel("inven4","merk4","4","lusin","ruang4","ket 4","jenis 4","R.drawable.ic_launcher_background","4 4 2004");
        mInventoryModels.add(inventoryModel);
    }
}
