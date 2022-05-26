package com.example.project2_imago;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project2_imago.databinding.ActivityGamingBinding;

import java.util.ArrayList;

public class CategoryActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityGamingBinding binding;

    ArrayList<Monitor> monitors;
    ItemViewHolder vh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGamingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);


        RecyclerView GamingRecycler = (RecyclerView) findViewById(R.id.gamingRecycler);

        monitors = DataProvider.returnCategory("Gaming");
        CategoryAdapter GamingAdapter = new CategoryAdapter(monitors);
        GamingRecycler.setAdapter(GamingAdapter);
        GamingRecycler.setLayoutManager(new LinearLayoutManager(this));
    }

    public void showSearchActivity(View view) {
        Intent searchActivity = new Intent(this, CategoryActivity.class);
        startActivity(searchActivity);
    }

    public void showFilterActivity(View view) {
        Intent filterActivity = new Intent(this,FilterActivity.class);
        startActivity(filterActivity);
    }

    public void showItemActivity(View view) {
        Intent itemActivity = new Intent(this, ItemActivity.class);
        startActivity(itemActivity);
    }

}