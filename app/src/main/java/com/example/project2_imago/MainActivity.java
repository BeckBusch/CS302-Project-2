package com.example.project2_imago;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

public class MainActivity extends AppCompatActivity {

    String category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        //DataProvider.getTopPicks();
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
}