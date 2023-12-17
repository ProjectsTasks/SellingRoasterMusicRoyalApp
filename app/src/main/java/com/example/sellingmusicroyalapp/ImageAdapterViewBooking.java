package com.example.sellingmusicroyalapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class ImageAdapterViewBooking extends FirebaseRecyclerAdapter<UserBooking, ImageAdapterViewBooking.ImageViewHolder> {

    private OnItemClickListener mListener;

    public ImageAdapterViewBooking(@NonNull FirebaseRecyclerOptions<UserBooking> options) {
        super(options);
    }
    @Override
    protected void onBindViewHolder(@NonNull ImageViewHolder holder, int position, @NonNull UserBooking model) {
        holder.textName.setText("Teacher Name: "+model.getBookingName());
        holder.textPrice.setText("Price: "+model.getBookingPrice());

    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.image_item_view_booking, parent, false);
        return new ImageViewHolder(v);
    }


    public class ImageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView textName;
        public TextView textPrice;
        public Button btn_view;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            textName= itemView.findViewById(R.id.t_name1);
            textPrice= itemView.findViewById(R.id.t_price1);
            btn_view= itemView.findViewById(R.id.btn_view);

            btn_view.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            if (mListener != null) {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    mListener.onItemClick(position);
                }
            }
        }

    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener= listener;
    }


    }

