package com.example.hw2_v2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {
    public ArrayList<Food> menuArrayList = FoodDatabase.getMenuArrayList();

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_menu, parent, false);
        return new FoodViewHolder(view);
    }

    @SuppressLint("DefaultLocale")
    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        final Food foodAtPosition = menuArrayList.get(position);
        holder.menuName.setText(foodAtPosition.getFoodName());
        holder.menuCost.setText(String.format("$%.2f", foodAtPosition.getFoodCost()));
        holder.menuPicture.setImageResource(foodAtPosition.getFoodPicture());

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();

                Intent intent = new Intent(context, FoodDetailActivity.class);
                intent.putExtra("foodId", foodAtPosition.getFoodId());
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return menuArrayList.size();
    }


    public class FoodViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public TextView menuName;
        public TextView menuCost;
        public ImageView menuPicture;

        public FoodViewHolder(@NonNull View v) {
            super(v);
            view = v;
            menuName = v.findViewById(R.id.menu_name);
            menuCost = v.findViewById(R.id.menu_cost);
            menuPicture = v.findViewById(R.id.menu_picture);
        }
    }
}
