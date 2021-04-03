package com.project.Adapters;

import com.project.model.Main;
import com.project.viewmodel.Mainmodel;
import java.util.ArrayList;
import java.util.List;
import io.reactivex.rxjava3.core.Observable;

public class Api {

    private List<Mainmodel> list = new ArrayList<>();
    private Mainmodel Datamodel;
    public Observable<List<Mainmodel>> observable;

    public void listPost() {
        for (int i = 0; i <= 2; i++) {
            switch (i) {
                case 0: {
                    Datamodel = new Mainmodel(new Main("camera", "one"));
                    break;
                }
                case 1: {
                    Datamodel = new Mainmodel(new Main("plus", "two"));
                    break;
                }
                case 2: {
                    Datamodel = new Mainmodel(new Main("clock", "three"));
                    break;
                }
            }

            list.add(Datamodel);
            observable=Observable.just(list);
        }
    }

}
