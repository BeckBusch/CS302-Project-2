package com.example.project2_imago;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
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
import com.example.project2_imago.databinding.ActivitySearchBinding;

import java.util.ArrayList;
import java.util.Objects;

public class CategoryActivity extends AppCompatActivity implements ItemClickListener {

    private AppBarConfiguration appBarConfiguration;
    private ActivityGamingBinding bindingGaming;
    private ActivityDesignBinding bindingDesign;
    private ActivityBusinessBinding bindingBusiness;
    private ActivitySearchBinding bindingSearch;
    private String category;
    private CategoryAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private ArrayList<String> brandFilter;

    androidx.appcompat.widget.Toolbar mActionBarToolbar;

    ArrayList<Monitor> monitors;
    DataProvider dataProviderObj = new DataProvider();


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
            monitors = dataProviderObj.returnCategory("Gaming");

        }
        else if (Objects.equals(category, "Design")) {
            setTitle("Design Monitors");
            bindingDesign = ActivityDesignBinding.inflate(getLayoutInflater());
            setContentView(bindingDesign.getRoot());
            setSupportActionBar(bindingDesign.toolbar);
            mRecyclerView = (RecyclerView) findViewById(R.id.designRecycler);
            monitors = dataProviderObj.returnCategory("Design");
        }

        else if (Objects.equals(category, "Business")) {
            setTitle("Business Monitors");
            bindingBusiness = ActivityBusinessBinding.inflate(getLayoutInflater());
            setContentView(bindingBusiness.getRoot());
            setSupportActionBar(bindingBusiness.toolbar);
            mRecyclerView = (RecyclerView) findViewById(R.id.businessRecycler);
            monitors = dataProviderObj.returnCategory("Business");
        }
        else if (Objects.equals(category,"Search")) {
            setTitle("Search");
            bindingSearch = ActivitySearchBinding.inflate(getLayoutInflater());
            setContentView(bindingSearch.getRoot());
            setSupportActionBar(bindingSearch.toolbar);

        }
        if (monitors == null) {

        } else {
            if (monitors.isEmpty()) {

            } else {
                mAdapter = new CategoryAdapter(monitors);
                mRecyclerView.setAdapter(mAdapter);
                mAdapter.setClickListener(this);
                mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
            }
        }


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
            i.putExtra("category","Design");
            i.putExtra("resolution",gMonitor.getResolution());
            i.putExtra("panelType",gMonitor.getPanelType());
        }
        System.out.println(monitor.getName());
        Log.i("Open",monitor.getName());
        startActivity(i);
        Animatoo.animateZoom(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        if (!Objects.equals(category,"Search")) {
            getMenuInflater().inflate(R.menu.category_action_bar, menu);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.search_icon:
                Intent searchActivity = new Intent(this,CategoryActivity.class);
                category = "Search";
                searchActivity.putExtra("category",category);
                startActivity(searchActivity);
                Animatoo.animateSlideDown(this);
                return true;

            case R.id.filter_icon:
                Intent filterActivity = new Intent(this,FilterActivity.class);
                filterActivity.putExtra("monitorList",monitors);
                mGetContent.launch(filterActivity);
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

    // GetContent creates an ActivityResultLauncher<String> to allow you to pass
    // in the mime type you'd like to allow the user to select
    ActivityResultLauncher<Intent> mGetContent = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if (result.getResultCode() == Activity.RESULT_OK) {
                // There are no request codes
                Intent data = result.getData();
                Bundle extras = data.getExtras();
                brandFilter = extras.getStringArrayList("brandFilter");
                updateRecycler();
            }
        }
    });

    private void updateRecycler() {

        ArrayList<Monitor> monitors1 = monitors;
        mAdapter.notifyDataSetChanged();
        if (!brandFilter.isEmpty()){
            for (Monitor monitor : monitors) {
                if (!brandFilter.contains(monitor.getBrand())) {
                    monitors1.remove(monitor);
                }
            }
        }
        mAdapter = new CategoryAdapter(monitors);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setClickListener(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter.notifyDataSetChanged();
    }

    public void updateSearchParameters(View view) {
        EditText editText = findViewById(R.id.searchBar);
        String searchTerm = editText.getText().toString();
        monitors = dataProviderObj.returnSearch(searchTerm);
        TextView error = (TextView) findViewById(R.id.error);
        if (monitors.isEmpty()) {
            error.setVisibility(View.VISIBLE);
        } else {error.setVisibility(View.INVISIBLE);}
        mRecyclerView = (RecyclerView) findViewById(R.id.searchRecycler);
        mAdapter = new CategoryAdapter(monitors);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setClickListener(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}