package com.project.Repo.range;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.project.R;
import com.project.databinding.ActivityRangeBinding;

public class RangeActivity extends AppCompatActivity {

    private ActivityRangeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_range);
    }
}