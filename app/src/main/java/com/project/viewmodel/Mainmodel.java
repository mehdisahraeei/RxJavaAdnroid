package com.project.viewmodel;


import androidx.databinding.BaseObservable;
import com.project.model.Main;

public class Mainmodel extends BaseObservable {


    public String title1, title2;

    public Mainmodel(Main main) {
        this.title1 = main.title1;
        this.title2 = main.title2;
    }


}
