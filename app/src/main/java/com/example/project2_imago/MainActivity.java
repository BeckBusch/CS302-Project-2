package com.example.project2_imago;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ItemClickListener {

    String category;
    private ArrayList<Monitor> monitors;
    private RecyclerView mRecyclerView;
    private TopPicksAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.topPicksRecycler);
        monitors = DataProvider.getTopPicks();
        mAdapter = new TopPicksAdapter(monitors);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setClickListener(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
    }


    public void ShowGamingActivity(View view){
        Intent gamingActivity= new Intent(this, CategoryActivity.class);
        category = "Gaming";
        gamingActivity.putExtra("category",category);
        startActivity(gamingActivity);
        Animatoo.animateSlideLeft(this);
    }

    public void ShowBusinessActivity(View view){
        Intent businessActivity= new Intent(this, CategoryActivity.class);
        category = "Business";
        businessActivity.putExtra("category",category);
        startActivity(businessActivity);
        Animatoo.animateSlideLeft(this);
    }

    public void ShowDesignActivity(View view){
        Intent designActivity= new Intent(this, CategoryActivity.class);
        category = "Design";
        designActivity.putExtra("category",category);
        startActivity(designActivity);
        Animatoo.animateSlideLeft(this);
    }

    public void showSearchActivity(View view) {
        Intent searchActivity = new Intent(this,CategoryActivity.class);
        category = "Search";
        searchActivity.putExtra("category",category);
        startActivity(searchActivity);
        Animatoo.animateSlideDown(this);
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
        Animatoo.animateZoom(this);
    }


}