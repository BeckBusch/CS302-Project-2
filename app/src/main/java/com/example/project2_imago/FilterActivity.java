package com.example.project2_imago;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.project2_imago.databinding.ActivityFilterBinding;

import java.util.ArrayList;

public class FilterActivity extends AppCompatActivity {

    private ScrollView scroll;
    private ActivityFilterBinding bindingFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle extras = getIntent().getExtras();
        ArrayList<Monitor> monitors;
        monitors = (ArrayList<Monitor>) extras.get("monitorList");

        bindingFilter = ActivityFilterBinding.inflate(getLayoutInflater());
        setContentView(bindingFilter.getRoot());

        scroll = (ScrollView) findViewById(R.id.scrollView);
        if (scroll == null){
            System.out.println("not found");
        }
        final LinearLayout linear = new LinearLayout(this);
        linear.setOrientation(LinearLayout.VERTICAL);
        scroll.addView(linear);

        ArrayList<String> brands = new ArrayList<>();
        ArrayList<String> aspectRatios = new ArrayList<>();
        ArrayList<String> resolutions = new ArrayList<>();
        ArrayList<String> panelTypes = new ArrayList<>();
        ArrayList<Integer> refreshRates = new ArrayList<>();
        ArrayList<Integer> responseTimes = new ArrayList<>();
        ArrayList<Integer> screenSizes = new ArrayList<>();
        ArrayList<Integer> vesaSizes = new ArrayList<>();

        TextView brandTitle = new TextView(this);
        brandTitle.setText("Brand");
        linear.addView(brandTitle);
        for (Monitor monitor:monitors) {
            String brand = monitor.getBrand();
            if (!brands.contains(brand)) {
                CheckBox ch = new CheckBox(this);
                ch.setId(R.id.checkbox1);
                ch.setText(brand);
                linear.addView(ch);
                brands.add(brand);
            }
        }

        TextView aRTitle = new TextView(this);
        aRTitle.setText("Aspect Ratio");
        linear.addView(aRTitle);
        for (Monitor monitor:monitors) {
            String aspectRatio = monitor.getAspectRatio();
            if (!aspectRatios.contains(aspectRatio)) {
                CheckBox ch = new CheckBox(this);
                ch.setText(aspectRatio);
                linear.addView(ch);
                aspectRatios.add(aspectRatio);
            }
        }

        TextView sSTitle = new TextView(this);
        sSTitle.setText("Screen Size");
        linear.addView(sSTitle);
        for (Monitor monitor:monitors) {
            Integer screenSize = monitor.getScreenSize();
            if (!screenSizes.contains(screenSize)) {
                CheckBox ch = new CheckBox(this);
                ch.setText(screenSize.toString());
                linear.addView(ch);
                screenSizes.add(screenSize);
            }
        }
    }

    public void filterRecycler(View view) {
        finish();
        Animatoo.animateSlideRight(this);
    }

}
