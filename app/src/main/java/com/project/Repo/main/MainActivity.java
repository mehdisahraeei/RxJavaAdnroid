package com.project.Repo.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.project.Adapters.AdapterMain;
import com.project.Adapters.Api;
import com.project.R;
import com.project.databinding.ActivityMainBinding;
import com.project.viewmodel.Mainmodel;

import java.util.List;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private RecyclerView recyclerView;
    private Api api;
    private Observer<List<Mainmodel>> observer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview1);
        api = new Api();
        api.listPost();


        observer = new Observer<List<Mainmodel>>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                //------Disposable d==Subscribes-------------
                Toast.makeText(MainActivity.this, d.toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNext(@NonNull List<Mainmodel> mainmodels) {
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                recyclerView.setAdapter(new AdapterMain(mainmodels));
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
        api.observable.subscribe(observer);


    }
}