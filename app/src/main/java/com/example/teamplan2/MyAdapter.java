package com.example.teamplan2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private Integer[] mimages;
    private String[] mplaces;
    private LayoutInflater minflater;
    private ItemClickListener mClickListener;


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView image;
        TextView place,location,info;
        ViewHolder(View v) {
            super(v);
            image = v.findViewById(R.id.image);
            place = v.findViewById(R.id.place);
            location = v.findViewById(R.id.location);
            info = v.findViewById(R.id.info);
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View view){
            if (mClickListener!=null) {
                mClickListener.onItemClick(view, getAdapterPosition());
            }
        }
    }
    void setClickListener(ItemClickListener itemClickListener){
        this.mClickListener = itemClickListener;
    }
    public interface ItemClickListener{
        void onItemClick(View view, int position);
    }

    public MyAdapter(Context context, Integer[] images, String[] places){
        this.minflater = LayoutInflater.from(context);
        this.mimages = images;
        this.mplaces = places;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = minflater.inflate(R.layout.cplacelist,null,true);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.place.setText(mplaces[position]);
        holder.image.setImageResource(mimages[position]);
        holder.location.setText("1");
        holder.info.setText("1");
    }

    @Override
    public int getItemCount() {
        return mplaces.length;
    }


}

