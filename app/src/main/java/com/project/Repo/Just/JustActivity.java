package com.project.Repo.Just;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.project.R;
import com.project.databinding.ActivityJustBinding;

public class JustActivity extends AppCompatActivity {

    private ActivityJustBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_just);

    }
}