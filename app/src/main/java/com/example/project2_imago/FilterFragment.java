package com.example.project2_imago;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class FilterFragment extends Fragment {

    View view;
    Button filterButton;

    public FilterFragment() {
        super(R.layout.activity_filter);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_filter, container, false);
        filterButton = (Button) view.findViewById(R.id.filterButton);
        filterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "First Fragment", Toast.LENGTH_LONG).show();
            }
        });

        LinearLayout linear = (LinearLayout) view.findViewById(R.id.linear);

        ArrayList<String> brands = requireArguments().getStringArrayList("brands");
        TextView brandsHeader = new TextView(getActivity());
        brandsHeader.setText("brand");
        linear.addView(brandsHeader);
        for (String brand:brands) {
            System.out.println(brand);
            CheckBox brandCheckBox = new CheckBox(getActivity());
            brandCheckBox.setText(brand);
            linear.addView(brandCheckBox);

        }
        return view;
    }
}

