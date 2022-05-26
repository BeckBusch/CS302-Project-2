package com.example.project2_imago;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
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

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_activity_gaming);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        RecyclerView GamingRecycler = (RecyclerView) findViewById(R.id.gamingRecycler);

        monitors = DataProvider.returnCategory("Gaming");
        CategoryAdapter GamingAdapter = new CategoryAdapter(monitors);
        GamingRecycler.setAdapter(GamingAdapter);
        GamingRecycler.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_activity_gaming);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }


}