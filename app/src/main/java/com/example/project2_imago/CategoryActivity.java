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

        /*vh = new ItemViewHolder();
        ArrayList<Monitor> monitors = DataProvider.generateData("gaming");
        ArrayList<String> names = new ArrayList<>();
        String text = "";
        for (int i = 0; i < monitors.size(); i++)
        {
            text+= monitors.get(i).getName()+"\n";
            names.add(monitors.get(i).getName());

        }*/
        monitors = DataProvider.getData("gaming");
        CategoryAdapter GamingAdapter = new CategoryAdapter("gaming");
        RecyclerView GamingRecycler = findViewById(R.id.gamingRecycler);
        GamingRecycler.setAdapter(GamingAdapter);
        GamingRecycler.setLayoutManager(new LinearLayoutManager(this));


        //vh.tempTextView.setText(text);
        /*binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_activity_gaming);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }


}