package com.example.hw2_v2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FoodDetailActivity extends AppCompatActivity implements View.OnClickListener {
    private Food food;

    private TextView detailName;
    private TextView detailCost;
    private TextView detailDescription;
    private ImageView detailPicture;

    private TextView detailCount;
    private int quantity;


    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_detail);

        // create intent
        Intent intent = getIntent();
        int foodId = intent.getIntExtra("foodId", 0);

        // grab selected food
        food = FoodDatabase.getMenuFoodById(foodId);

        // link stuff to their layout ids
        detailName = findViewById(R.id.detail_name);
        detailCost = findViewById(R.id.detail_cost);
        detailDescription = findViewById(R.id.detail_description);
        detailPicture = findViewById(R.id.detail_picture);
        detailCount = findViewById(R.id.detail_count);

        // give layout ids their info
        detailName.setText(food.getFoodName());
        detailCost.setText(String.format("$%.2f", food.getFoodCost()));
        detailDescription.setText(food.getFoodDescription());
        detailPicture.setImageResource(food.getFoodPicture());
        detailCount.setText(String.valueOf(food.getFoodCount()));
        quantity = food.getFoodCount();

        // make buttons do stuff
        Button add = findViewById(R.id.detail_remove);
        Button minus = findViewById(R.id.detail_add);
        Button confirm = findViewById(R.id.detail_confirm);

        // assign listener
        add.setOnClickListener(this);
        minus.setOnClickListener(this);
        confirm.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.detail_add:
                // adding items, max
                if (quantity == 20) {
                    Toast.makeText(this, "You're ordering too many "+ food.getFoodName()+"s!", Toast.LENGTH_SHORT).show();
                } else {
                    quantity++;
                    detailCount.setText(String.valueOf(quantity));
                }
                break;
            case R.id.detail_remove:
                // removing items, min 0
                if (quantity == 0) {
                    Toast.makeText(this, "You can't remove any more "+ food.getFoodName()+"s!", Toast.LENGTH_SHORT).show();
                } else {
                    quantity--;
                    detailCount.setText(String.valueOf(quantity));
                }
                break;
            case R.id.detail_confirm:
                // add quantity to order
                food.setFoodCount(quantity);
                if (quantity == 1) {
                    Toast.makeText(this, "You now have " + quantity + " " + food.getFoodName() + " in your order!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "You now have " + quantity + " " + food.getFoodName() + "s in your order!", Toast.LENGTH_SHORT).show();

                }
                break;
        }

    }
}
