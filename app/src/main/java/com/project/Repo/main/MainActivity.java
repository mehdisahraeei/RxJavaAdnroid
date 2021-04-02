package com.project.Repo.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import com.project.Adapters.AdapterMain;
import com.project.R;
import com.project.databinding.ActivityMainBinding;
import com.project.model.Main;
import com.project.viewmodel.Mainmodel;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private RecyclerView recyclerView;
    private List<Mainmodel> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);


        recyclerView = findViewById(R.id.recyclerview1);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        list = new ArrayList<>();
        InsertOne();

        recyclerView.setAdapter(new AdapterMain(list));


    }


    public void InsertOne() {
        list.add(new Mainmodel(new Main("camera", "one")));
        list.add(new Mainmodel(new Main("plus", "two")));
        list.add(new Mainmodel(new Main("clock", "three")));
    }


}