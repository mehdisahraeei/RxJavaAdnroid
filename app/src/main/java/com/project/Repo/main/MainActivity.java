package com.project.Repo.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.project.Adapters.AdapterMain;
import com.project.Adapters.Api;
import com.project.R;
import com.project.Repo.Just.JustActivity;
import com.project.Repo.create.CreateActivity;
import com.project.Repo.flowable.FlowableActivity;
import com.project.Repo.interval.IntervalActivity;
import com.project.Repo.range.RangeActivity;
import com.project.Repo.timer.TimerActivity;
import com.project.databinding.ActivityMainBinding;
import com.project.viewmodel.ClickMainActivity;
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
        binding.setMain1(new ClickMainActivity() {
            @Override
            public void ClickMainActivity1(View view) {
                startActivity(new Intent(MainActivity.this, JustActivity.class));
            }

            @Override
            public void ClickMainActivity2(View view) {
                startActivity(new Intent(MainActivity.this, CreateActivity.class));
            }

            @Override
            public void ClickMainActivity3(View view) {
                startActivity(new Intent(MainActivity.this, RangeActivity.class));
            }


            @Override
            public void ClickMainActivity4(View view) {
                startActivity(new Intent(MainActivity.this, FlowableActivity.class));
            }


            @Override
            public void ClickMainActivity5(View view) {
                startActivity(new Intent(MainActivity.this, IntervalActivity.class));
            }

            @Override
            public void ClickMainActivity6(View view) {
                startActivity(new Intent(MainActivity.this, TimerActivity.class));
            }

        });


        recyclerView = findViewById(R.id.recyclerview1);
        api = new Api();
        api.listPost();


        observer = new Observer<List<Mainmodel>>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                //------Disposable d==Subscribes-------------
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