package com.example.project2_imago;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemActivity extends AppCompatActivity {


    private ItemAdapter mAdapter;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_item);
        Bundle extras = getIntent().getExtras();
        mRecyclerView = (RecyclerView) findViewById(R.id.picRecycler);
        ArrayList<String> drawableNames = extras.getStringArrayList("imageList");
        mAdapter = new ItemAdapter(drawableNames);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));


        String name;
        name = extras.getString("name");
        TextView nameView = findViewById(R.id.Title);
        nameView.setText(name);

        String aspectRatio = extras.getString("aspectRatio");
        TextView aRView = findViewById(R.id.aR);
        aRView.setText(aspectRatio);

        String screenSize = (Integer.toString(extras.getInt("screenSize"))+'"');
        TextView sSView = findViewById(R.id.sS);
        sSView.setText(screenSize);

        String brand = extras.getString("brand");
        TextView brandView = findViewById(R.id.brand);
        brandView.setText(brand);

        String price = ("$"+ extras.getInt("price"));
        TextView priceView = findViewById(R.id.price);
        priceView.setText(price);

        if (extras.getString("category").equals("Gaming")) {
            String resolution = extras.getString("resolution");
            TextView resolutionView = findViewById(R.id.resolution);
            resolutionView.setText(resolution);

            String responseTime = (extras.getInt("responseTime") +"ms");
            TextView rTView = findViewById(R.id.rT);
            rTView.setText(responseTime);

            String refreshRate = (extras.getInt("refreshRate") +"Hz");
            TextView rRView = findViewById(R.id.rR);
            rRView.setText(refreshRate);

            TextView curvedView = findViewById(R.id.curved);
            if (extras.getBoolean("curved")) {
                curvedView.setText("Yes");
            } else { curvedView.setText("No"); }
        } else if (extras.getString("category").equals("Business")) {
            String vesaSize = (Integer.toString(extras.getInt("vesaSize")));
            TextView vSView = findViewById(R.id.vS);
            vSView.setText(vesaSize);

            TextView tSView = findViewById(R.id.tS);
            if (extras.getBoolean("touchscreen")) {
                tSView.setText("Yes");
            } else { tSView.setText("No"); }

        } else if (extras.getString("category").equals("Design")) {
            String resolution = extras.getString("resolution");
            TextView resolutionView = findViewById(R.id.resolution);
            resolutionView.setText(resolution);

            String panelType = extras.getString("panelType");
            TextView pTView = findViewById(R.id.pT);
            pTView.setText(panelType);
        }



    }


    public void goBack(View view) {
        finish();
    }
}