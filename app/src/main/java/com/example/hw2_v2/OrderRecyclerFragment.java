package com.example.hw2_v2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class OrderRecyclerFragment extends Fragment {
    private RecyclerView recyclerView;

    public OrderRecyclerFragment() {
        // constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_order_recycler, container, false);

        recyclerView = view.findViewById(R.id.order_rv_id);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);

        OrderAdapter orderAdapter = new OrderAdapter();
        recyclerView.setAdapter(orderAdapter);

        return view;

    }
}
