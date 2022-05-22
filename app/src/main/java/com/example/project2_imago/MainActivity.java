package com.example.project2_imago;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        DataProvider.getTopPicks();
    }


    public void ShowGamingActivity(View view){
        Intent gamingActivity= new Intent(this, CategoryActivity.class);
        startActivity(gamingActivity);
    }

    public void ShowBusinessActivity(View view){
        Intent businessActivity= new Intent(this, CategoryActivity.class);
        startActivity(businessActivity);
    }

    public void ShowDesignActivity(View view){
        Intent designActivity= new Intent(this, CategoryActivity.class);
        startActivity(designActivity);
    }
}