package com.nearby.vajidkagdi.nearby;

import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

import io.nlopez.smartlocation.OnLocationUpdatedListener;
import io.nlopez.smartlocation.SmartLocation;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;

public class Cafes extends AppCompatActivity {

    RecyclerView recyclerView;
    EditText editText;
    Button button;
    List<PlacesPOJO.CustomA> results;
    List<StoreModel> storeModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cafes);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        SearchData x = SearchData.getInstance();
        storeModels = x.getStoreModels();
        results = x.results;
        if (storeModels.size() == 10 || storeModels.size() == results.size()) {
            RecyclerViewAdapter adapterStores = new RecyclerViewAdapter(results, storeModels);
            recyclerView.setAdapter(adapterStores);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        SearchData x = SearchData.getInstance();
        storeModels = x.getStoreModels();
        results = x.results;
        if (storeModels.size() == 10 || storeModels.size() == results.size()) {
            RecyclerViewAdapter adapterStores = new RecyclerViewAdapter(results, storeModels);
            recyclerView.setAdapter(adapterStores);
        }

    }
}