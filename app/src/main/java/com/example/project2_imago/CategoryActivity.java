package com.example.project2_imago;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.project2_imago.databinding.ActivityBusinessBinding;
import com.example.project2_imago.databinding.ActivityDesignBinding;
import com.example.project2_imago.databinding.ActivityGamingBinding;

import java.util.ArrayList;
import java.util.Objects;

public class CategoryActivity extends AppCompatActivity implements ItemClickListener {

    private AppBarConfiguration appBarConfiguration;
    private ActivityGamingBinding bindingGaming;
    private ActivityDesignBinding bindingDesign;
    private ActivityBusinessBinding bindingBusiness;
    private String category;
    private CategoryAdapter mAdapter;
    private RecyclerView mRecyclerView;

    androidx.appcompat.widget.Toolbar mActionBarToolbar;

    ArrayList<Monitor> monitors;
    ItemViewHolder vh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle extras = getIntent().getExtras();
        category = extras.getString("category");



        if (Objects.equals(category, "Gaming")) {
            setTitle("Gaming Monitors");
            bindingGaming = ActivityGamingBinding.inflate(getLayoutInflater());
            setContentView(bindingGaming.getRoot());
            setSupportActionBar(bindingGaming.toolbar);
            mRecyclerView = (RecyclerView) findViewById(R.id.gamingRecycler);
            monitors = DataProvider.returnCategory("Gaming");

        }
        else if (Objects.equals(category, "Design")) {
            setTitle("Design Monitors");
            bindingDesign = ActivityDesignBinding.inflate(getLayoutInflater());
            setContentView(bindingDesign.getRoot());
            setSupportActionBar(bindingDesign.toolbar);
            mRecyclerView = (RecyclerView) findViewById(R.id.designRecycler);
            monitors = DataProvider.returnCategory("Design");
        }

        else if (Objects.equals(category, "Business")) {
            setTitle("Business Monitors");
            bindingBusiness = ActivityBusinessBinding.inflate(getLayoutInflater());
            setContentView(bindingBusiness.getRoot());
            setSupportActionBar(bindingBusiness.toolbar);
            mRecyclerView = (RecyclerView) findViewById(R.id.businessRecycler);
            monitors = DataProvider.returnCategory("Business");
        }

        mAdapter = new CategoryAdapter(monitors);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setClickListener(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        Toolbar myChildToolbar =
                (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myChildToolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    public void showSearchActivity(View view) {
        Intent searchActivity = new Intent(this, CategoryActivity.class);
        startActivity(searchActivity);
    }

    public void showFilterActivity(View view) {
        Intent filterActivity = new Intent(this,FilterActivity.class);
        filterActivity.putExtra("monitorList",monitors);
        startActivity(filterActivity);
    }

    public void goBack(View view) {
        finish();
        Animatoo.animateSlideRight(this);
    }

    @Override
    public void onClick(View view, int position) {
        System.out.println("pog");
        final Monitor monitor = monitors.get(position);
        Intent i = new Intent(this,ItemActivity.class);
        i.putExtra("name",monitor.getName());
        i.putExtra("imageList",monitor.getAllDrawables());
        i.putExtra("screenSize",monitor.getScreenSize());
        i.putExtra("aspectRatio",monitor.getAspectRatio());
        i.putExtra("brand",monitor.getBrand());
        i.putExtra("price",monitor.getPrice());

        if (monitor instanceof GamingMonitor) {
            GamingMonitor gMonitor = (GamingMonitor) monitor;
            i.putExtra("category","Gaming");
            i.putExtra("resolution",gMonitor.getResolution());
            i.putExtra("refreshRate",gMonitor.getRefreshRate());
            i.putExtra("responseTime",gMonitor.getResponseTime());
            i.putExtra("curved",gMonitor.getIsCurved());
        }

        else if (monitor instanceof BusinessMonitor) {
            BusinessMonitor gMonitor = (BusinessMonitor) monitor;
            i.putExtra("category","Business");
            i.putExtra("vesaSize",gMonitor.getVesaSize());
            i.putExtra("touchscreen",gMonitor.isTouchscreen());
        }

        else if (monitor instanceof DesignMonitor) {
            DesignMonitor gMonitor = (DesignMonitor) monitor;
            i.putExtra("category","Gaming");
            i.putExtra("resolution",gMonitor.getResolution());
            i.putExtra("panelType",gMonitor.getPanelType());
        }
        System.out.println(monitor.getName());
        Log.i("Open",monitor.getName());
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.category_action_bar, menu);
        return true;
    }


}