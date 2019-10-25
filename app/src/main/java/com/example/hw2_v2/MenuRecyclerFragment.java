package com.example.hw2_v2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MenuRecyclerFragment extends Fragment {

    private RecyclerView recyclerView;

    public MenuRecyclerFragment() {
        //  constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu_recycler, container, false);

        recyclerView = view.findViewById(R.id.menu_rv_id);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);

        FoodAdapter foodAdapter = new FoodAdapter();
        recyclerView.setAdapter(foodAdapter);

        return view;

    }

}
