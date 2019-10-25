package com.example.hw2_v2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    BottomNavigationView bottomNavigationView;
    public ArrayList<Food> orderArrayList = new ArrayList<>();
    double total;
    TextView mainTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // set up fragment
        Fragment fragment = new MenuRecyclerFragment();
        swapFragment(fragment);

        mainTotal = findViewById(R.id.main_total);
        mainTotal.setText("$0.00");

        // set up nav bar
        bottomNavigationView = findViewById(R.id.bottom_nav_id);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.nav_menu) {
                    Fragment fragment = new MenuRecyclerFragment();
                    swapFragment(fragment);
                    return true;
                } else if (menuItem.getItemId() == R.id.nav_order) {
                    Fragment fragment = new OrderRecyclerFragment();
                    swapFragment(fragment);
                    return true;
                }
                return false;
            }
        });

        // set update button
        Button mainUpdate = findViewById(R.id.main_update);
        mainUpdate.setOnClickListener(this);


    }

    public void swapFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_slot, fragment);
        fragmentTransaction.commit();
    }


    @SuppressLint("DefaultLocale")
    @Override
    public void onClick(View v) {
        total = 0;
        orderArrayList = FoodDatabase.getOrderArrayList();
        // sum up costs
        for (Food f: orderArrayList) {
            total+=(f.getFoodCost()*f.getFoodCount());
        }

        // set total
        mainTotal.setText(String.format("$%.2f", total));
        Toast.makeText(this, "Updating total...", Toast.LENGTH_SHORT).show();
    }
}
