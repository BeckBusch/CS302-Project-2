package com.example.project2_imago;

import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
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

        String price = ("$"+ extras.getInt("price"));
        TextView priceView = findViewById(R.id.price);
        priceView.setText(price);

        TableLayout tableLayout = findViewById(R.id.specsTable);

        TableRow brandRow = new TableRow(this);
        TextView brandTitle = new TextView(this);
        brandTitle.setPadding(10,10,10,10);
        brandTitle.setText("Brand:                            ");
        String brand = extras.getString("brand");
        TextView brandText = new TextView(this);
        brandText.setText(brand);
        brandRow.addView(brandTitle);
        brandRow.addView(brandText);
        tableLayout.addView(brandRow);

        TableRow aspectRatioRow = new TableRow(this);
        TextView aRTitle = new TextView(this);
        aRTitle.setPadding(10,10,10,10);
        aRTitle.setText("Aspect Ratio:");
        String aspectRatio = extras.getString("aspectRatio");
        TextView aRText = new TextView(this);
        aRText.setText(aspectRatio);
        aspectRatioRow.addView(aRTitle);
        aspectRatioRow.addView(aRText);
        tableLayout.addView(aspectRatioRow);

        TableRow sSRatioRow = new TableRow(this);
        TextView sSTitle = new TextView(this);
        sSTitle.setPadding(10,10,10,10);
        sSTitle.setText("Screen Size:");
        String screenSize = (Integer.toString(extras.getInt("screenSize"))+'"');
        TextView sSText = new TextView(this);
        sSText.setText(screenSize);
        sSRatioRow.addView(sSTitle);
        sSRatioRow.addView(sSText);
        tableLayout.addView(sSRatioRow);

        switch (extras.getString("category")) {
            case "Gaming": {
                TableRow resolutionRow = new TableRow(this);
                TextView resolutionTitle = new TextView(this);
                resolutionTitle.setPadding(10,10,10,10);
                resolutionTitle.setText("Resolution:");
                String resolution = extras.getString("resolution");
                TextView resolutionText = new TextView(this);
                resolutionText.setText(resolution);
                resolutionRow.addView(resolutionTitle);
                resolutionRow.addView(resolutionText);
                tableLayout.addView(resolutionRow);

                TableRow responseTimeRow = new TableRow(this);
                TextView responseTimeTitle = new TextView(this);
                responseTimeTitle.setPadding(10,10,10,10);
                responseTimeTitle.setText("Response Time:");
                String responseTime = (extras.getInt("responseTime") + "ms");
                TextView responseTimeText = new TextView(this);
                responseTimeText.setText(responseTime);
                responseTimeRow.addView(responseTimeTitle);
                responseTimeRow.addView(responseTimeText);
                tableLayout.addView(responseTimeRow);

                TableRow refreshRateRow = new TableRow(this);
                TextView refreshRateTitle = new TextView(this);
                refreshRateTitle.setPadding(10,10,10,10);
                refreshRateTitle.setText("Refresh Rate:");
                String refreshRate = (extras.getInt("refreshRate") + "Hz");
                TextView refreshRateText = new TextView(this);
                refreshRateText.setText(refreshRate);
                refreshRateRow.addView(refreshRateTitle);
                refreshRateRow.addView(refreshRateText);
                tableLayout.addView(refreshRateRow);

                String curved = null;
                if (extras.getBoolean("curved")) {
                    curved = "Yes";
                } else {
                    curved = "No";
                }
                TableRow curvedRow = new TableRow(this);
                TextView curvedTitle = new TextView(this);
                curvedTitle.setPadding(10,10,10,10);
                curvedTitle.setText("Curved:");
                TextView curvedText = new TextView(this);
                curvedText.setText(curved);
                curvedRow.addView(curvedTitle);
                curvedRow.addView(curvedText);
                tableLayout.addView(curvedRow);
                break;
            }
            case "Business":

                TableRow vesaRow = new TableRow(this);
                TextView vesaTitle = new TextView(this);
                vesaTitle.setPadding(10,10,10,10);
                vesaTitle.setText("Vesa Size:");
                String vesa = (extras.getInt("vesaSize") + "Hz");
                TextView vesaText = new TextView(this);
                vesaText.setText(vesa);
                vesaRow.addView(vesaTitle);
                vesaRow.addView(vesaText);
                tableLayout.addView(vesaRow);

                String touchscreen = null;
                if (extras.getBoolean("touchscreen")) {
                    touchscreen = "Yes";
                } else {
                    touchscreen = "No";
                }
                TableRow touchscreenRow = new TableRow(this);
                TextView touchscreenTitle = new TextView(this);
                touchscreenTitle.setPadding(10,10,10,10);
                touchscreenTitle.setText("TouchScreen:");
                TextView touchscreenText = new TextView(this);
                touchscreenText.setText(touchscreen);
                touchscreenRow.addView(touchscreenTitle);
                touchscreenRow.addView(touchscreenText);
                tableLayout.addView(touchscreenRow);
                break;
            case "Design": {
                TableRow resolutionRow = new TableRow(this);
                TextView resolutionTitle = new TextView(this);
                resolutionTitle.setText("Resolution:");
                resolutionTitle.setPadding(10,10,10,10);
                String resolution = extras.getString("resolution");
                TextView resolutionText = new TextView(this);
                resolutionText.setText(resolution);
                resolutionRow.addView(resolutionTitle);
                resolutionRow.addView(resolutionText);
                tableLayout.addView(resolutionRow);

                TableRow panelTypeRow = new TableRow(this);
                TextView panelTypeTitle = new TextView(this);
                panelTypeTitle.setPadding(10,10,10,10);
                panelTypeTitle.setText("Panel Type:");
                String panelType = extras.getString("panelType");
                TextView panelTypeText = new TextView(this);
                panelTypeText.setText(panelType);
                panelTypeRow.addView(panelTypeTitle);
                panelTypeRow.addView(panelTypeText);
                tableLayout.addView(panelTypeRow);

                break;
            }
        }



    }


    public void goBack(View view) {
        finish();
    }
}