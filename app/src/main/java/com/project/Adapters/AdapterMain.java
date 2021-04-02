package com.project.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.project.R;
import com.project.viewmodel.Mainmodel;
import com.project.databinding.BodyRecyclerviewBinding;

import java.util.List;


public class AdapterMain extends RecyclerView.Adapter<AdapterMain.RecyclerviewHolder> {

    private List<Mainmodel> mainList;


    public AdapterMain(List<Mainmodel> modelmains) {
        this.mainList = modelmains;
    }


    @NonNull
    @Override
    public RecyclerviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        BodyRecyclerviewBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.body_recyclerview, parent, false);

        return new AdapterMain.RecyclerviewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerviewHolder holder, int position) {
        Mainmodel model1 = mainList.get(position);
        holder.bindMain(model1);
        holder.bind.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position == 0) {
                    Toast.makeText(v.getContext(), "1", Toast.LENGTH_SHORT).show();
                } else if (position == 1) {
                    Toast.makeText(v.getContext(), "2", Toast.LENGTH_SHORT).show();
                } else if (position == 2) {
                    Toast.makeText(v.getContext(), "3", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return mainList.size();
    }


    public class RecyclerviewHolder extends RecyclerView.ViewHolder {

        private BodyRecyclerviewBinding bind;


        public RecyclerviewHolder(BodyRecyclerviewBinding bind) {
            super(bind.getRoot());
            this.bind = bind;
        }

        public void bindMain(Mainmodel m) {
            this.bind.setViewBind(m);
        }

    }

}
