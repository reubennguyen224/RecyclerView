package com.rikkei.training.ui.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Button btnLinear, btnGrid, btnStaggered;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGrid = findViewById(R.id.gridlayout);
        btnLinear = findViewById(R.id.linearlayout);
        btnStaggered = findViewById(R.id.staggerdlayout);
        recyclerView = findViewById(R.id.recyclerView);

        ArrayList<Model> arrayList = new ArrayList<>();
        arrayList.add(new Model("A", "bcd"));
        arrayList.add(new Model("B", "cde"));
        arrayList.add(new Model("C", "deg"));
        arrayList.add(new Model("D", "egh"));
        arrayList.add(new Model("E", "ghi"));
        arrayList.add(new Model("F", "hij"));
        arrayList.add(new Model("G", "ijk"));
        arrayList.add(new Model("H", "jkl"));
        arrayList.add(new Model("I", "klm"));
        arrayList.add(new Model("J", "lmn"));
        arrayList.add(new Model("K", "mno"));

        btnLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                recyclerView.setAdapter(new Adapter(getApplicationContext(), arrayList));
            }
        });

        btnGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2, GridLayoutManager.VERTICAL, false));
                adapter = new Adapter(getApplicationContext(), arrayList);
                recyclerView.setAdapter(adapter);
            }
        });

        btnStaggered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.HORIZONTAL));
                recyclerView.setAdapter(new Adapter(getApplicationContext(), arrayList));
            }
        });
    }
}