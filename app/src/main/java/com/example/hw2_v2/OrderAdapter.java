package com.example.hw2_v2;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder> {
    public ArrayList<Food> orderArrayList = FoodDatabase.getOrderArrayList();

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_order, parent, false);
        return new OrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {

        final Food foodAtPosition = orderArrayList.get(position);
        holder.orderName.setText(foodAtPosition.getFoodName());
        holder.orderCount.setText("Qty: " + foodAtPosition.getFoodCount());
        holder.orderPicture.setImageResource(foodAtPosition.getFoodPicture());

    }

    @Override
    public int getItemCount() {
        return orderArrayList.size();
    }

    public class OrderViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public TextView orderName;
        public TextView orderCount;
        public ImageView orderPicture;

        public OrderViewHolder(@NonNull View v) {
            super(v);
            view = v;
            orderName = v.findViewById(R.id.order_name);
            orderCount = v.findViewById(R.id.order_count);
            orderPicture = v.findViewById(R.id.order_picture);
        }
    }
}
