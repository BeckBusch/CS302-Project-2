package com.example.project2_imago;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.project2_imago.databinding.ActivityBusinessBinding;
import com.example.project2_imago.databinding.ActivityDesignBinding;
import com.example.project2_imago.databinding.ActivityGamingBinding;

import java.util.ArrayList;
import java.util.Objects;

public class CategoryActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityGamingBinding bindingGaming;
    private ActivityDesignBinding bindingDesign;
    private ActivityBusinessBinding bindingBusiness;
    private String category;

    androidx.appcompat.widget.Toolbar mActionBarToolbar;

    ArrayList<Monitor> monitors;
    ItemViewHolder vh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle extras = getIntent().getExtras();
        category = extras.getString("category");
//        mActionBarToolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.toolbar);
//        if (mActionBarToolbar != null) {
//            System.out.println("unpog");
//        } else
//        setSupportActionBar(mActionBarToolbar);
//        getSupportActionBar().setTitle(category);
        if (Objects.equals(category, "Gaming")) {

            bindingGaming = ActivityGamingBinding.inflate(getLayoutInflater());
            setContentView(bindingGaming.getRoot());

            setSupportActionBar(bindingGaming.toolbar);
            RecyclerView GamingRecycler = (RecyclerView) findViewById(R.id.gamingRecycler);

            monitors = DataProvider.returnCategory("Gaming");
            CategoryAdapter GamingAdapter = new CategoryAdapter(monitors);
            GamingRecycler.setAdapter(GamingAdapter);
            GamingRecycler.setLayoutManager(new LinearLayoutManager(this));
        }
        else if (Objects.equals(category, "Design")) {
            bindingDesign = ActivityDesignBinding.inflate(getLayoutInflater());
            setContentView(bindingDesign.getRoot());

            setSupportActionBar(bindingDesign.toolbar);
            RecyclerView designRecycler = (RecyclerView) findViewById(R.id.designRecycler);

            monitors = DataProvider.returnCategory("Design");
            CategoryAdapter designAdapter = new CategoryAdapter(monitors);
            designRecycler.setAdapter(designAdapter);
            designRecycler.setLayoutManager(new LinearLayoutManager(this));
        }

        else if (Objects.equals(category, "Business")) {
            bindingBusiness = ActivityBusinessBinding.inflate(getLayoutInflater());
            setContentView(bindingBusiness.getRoot());

            setSupportActionBar(bindingBusiness.toolbar);
            RecyclerView businessRecycler = (RecyclerView) findViewById(R.id.businessRecycler);

            monitors = DataProvider.returnCategory("Business");
            CategoryAdapter businessAdapter = new CategoryAdapter(monitors);
            businessRecycler.setAdapter(businessAdapter);
            businessRecycler.setLayoutManager(new LinearLayoutManager(this));
        }
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

    public void goBack(View view) {
        finish();
        Animatoo.animateSlideRight(this);
    }

}