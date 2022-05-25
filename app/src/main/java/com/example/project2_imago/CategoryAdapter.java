package com.example.project2_imago;

import android.content.Context;
import android.util.Log;
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

    // BEGIN_INCLUDE(recyclerViewSampleViewHolder)
    /**
     * Provide a reference to the type of views that you are using (custom ViewHolder)
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView nametextView;
        public ImageView pic1ItemView;

        public ViewHolder(View v) {
            super(v);
            // Define click listener for the ViewHolder's View.
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "Element " + getAdapterPosition() + " clicked.");
                }
            });
            nametextView = (TextView) v.findViewById(R.id.textview_first);
            pic1ItemView = (ImageView) v.findViewById(R.id.Monitor_Pic1);
        }

        public TextView getTextView() {
            return nametextView;
        }
    }
    // END_INCLUDE(recyclerViewSampleViewHolder)

    public CategoryAdapter(String category) {

        monitors = DataProvider.returnCategory(category);
    }

    // END_INCLUDE(recyclerViewOnCreateViewHolder)

    @Override
    public CategoryAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view.
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.text_row_item, viewGroup, false);

        return new ViewHolder(v);
    }

    // BEGIN_INCLUDE(recyclerViewOnBindViewHolder)
    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        Log.d(TAG, "Element " + position + " set.");

        Monitor monitor = monitors.get(position);

        TextView textview = viewHolder.nametextView;
        textview.setText(monitor.getName());
        ImageView imageView = viewHolder.pic1ItemView;
        int id = R.drawable.monitor1;
        imageView.setImageResource(id);
        // Get element from your dataset at this position and replace the contents of the view
        // with that element
        viewHolder.getTextView().setText(monitors.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return monitors.size();
    }
    // END_INCLUDE(recyclerViewOnBindViewHolder)

}

