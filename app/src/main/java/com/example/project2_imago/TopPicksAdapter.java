package com.example.project2_imago;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TopPicksAdapter extends RecyclerView.Adapter<TopPicksAdapter.ViewHolder> {
    private static final String TAG = "CustomAdapter";

    private ArrayList<Monitor> monitors;
    private ItemClickListener clickListener;


    // END_INCLUDE(recyclerViewSampleViewHolder)

    public TopPicksAdapter(ArrayList<Monitor> monitorList) {
        this.monitors = monitorList;
    }

    // END_INCLUDE(recyclerViewOnCreateViewHolder)

    @Override
    public TopPicksAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view.
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.top_pick, viewGroup, false);

        return new TopPicksAdapter.ViewHolder(v);
    }

    // BEGIN_INCLUDE(recyclerViewOnBindViewHolder)
    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(TopPicksAdapter.ViewHolder viewHolder, int position) {

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

        public ImageView pic1ItemView;
        private TextView nameTextView;

        public ViewHolder(View v) {
            super(v);
            pic1ItemView = (ImageView) v.findViewById(R.id.Monitor_Pic1);
            nameTextView = (TextView) v.findViewById(R.id.Monitor_Name);
            v.setTag(v);
            v.setOnClickListener((View.OnClickListener) this);
        }
        public TextView getTextView() { return nameTextView;}
        public ImageView getImageView() { return  pic1ItemView;}

        @Override
        public void onClick(View v) {
            clickListener.onClick(v, getAdapterPosition());
        }


    }
}
