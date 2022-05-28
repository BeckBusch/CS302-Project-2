package com.example.project2_imago;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
    private static final String TAG = "CustomAdapter";

    private ArrayList<String> drawableNames;


    // END_INCLUDE(recyclerViewSampleViewHolder)

    public ItemAdapter(ArrayList<String> names) {
        this.drawableNames = names;
    }

    // END_INCLUDE(recyclerViewOnCreateViewHolder)

    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view.
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.item_pic, viewGroup, false);

        return new ViewHolder(v);
    }

    // BEGIN_INCLUDE(recyclerViewOnBindViewHolder)
    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ItemAdapter.ViewHolder viewHolder, int position) {
        String drawName = drawableNames.get(position);
        ImageView imageView = viewHolder.getImageView();
        Context context = imageView.getContext();
        int id = context.getResources().getIdentifier(drawName,"drawable", context.getPackageName());

        imageView.setImageResource(id);
    }

    @Override
    public int getItemCount() {
        return drawableNames.size();
    }
    // END_INCLUDE(recyclerViewOnBindViewHolder)

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView nameTextView;
        public ImageView pic1ItemView;

        public ViewHolder(View v) {
            super(v);
            pic1ItemView = (ImageView) v.findViewById(R.id.imageView);
            v.setTag(v);
        }

        public ImageView getImageView() { return  pic1ItemView;}
    }

}

