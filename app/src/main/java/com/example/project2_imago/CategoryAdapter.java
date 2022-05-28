package com.example.project2_imago;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    private static final String TAG = "CustomAdapter";

    private ArrayList<Monitor> monitors;
    private ItemClickListener clickListener;


    // END_INCLUDE(recyclerViewSampleViewHolder)

    public CategoryAdapter(ArrayList<Monitor> monitorList) {
        this.monitors = monitorList;
    }

    // END_INCLUDE(recyclerViewOnCreateViewHolder)

    @Override
    public CategoryAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view.
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.recycler_item, viewGroup, false);

        return new ViewHolder(v);
    }

    // BEGIN_INCLUDE(recyclerViewOnBindViewHolder)
    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(CategoryAdapter.ViewHolder viewHolder, int position) {
        Monitor monitor = monitors.get(position);
        TextView textview = viewHolder.getTextView();
        String name;
        name = monitor.getName();
        textview.setText(name);

        ImageView imageView = viewHolder.getImageView();
        String drawName = monitor.getDrawableName();
        Context context = imageView.getContext();
        int id = context.getResources().getIdentifier(drawName,"drawable", context.getPackageName());

        imageView.setImageResource(id);
    }

    @Override
    public int getItemCount() {
        return monitors.size();
    }
    // END_INCLUDE(recyclerViewOnBindViewHolder)

    public void setClickListener(ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView nameTextView;
        public ImageView pic1ItemView;

        public ViewHolder(View v) {
            super(v);
            nameTextView = (TextView) v.findViewById(R.id.Monitor_Name);
            pic1ItemView = (ImageView) v.findViewById(R.id.Monitor_Pic1);
            v.setTag(v);
            v.setOnClickListener((View.OnClickListener) this);
        }

        public TextView getTextView() {
            return nameTextView;
        }
        public ImageView getImageView() { return  pic1ItemView;}

        @Override
        public void onClick(View v) {
            clickListener.onClick(v, getAdapterPosition());
        }
    }

}

