package com.project.Repo.create;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import android.widget.Toast;
import com.project.R;
import com.project.databinding.ActivityCreateBinding;
import com.project.model.Main;
import com.project.viewmodel.Mainmodel;
import java.util.ArrayList;
import java.util.List;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;


public class CreateActivity extends AppCompatActivity {

    private ActivityCreateBinding binding;
    private Observable<List<Mainmodel>> observable;
    private List<Mainmodel> list = new ArrayList<>();
    private Observer<List<Mainmodel>> observer;
    private Mainmodel mainmodel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_create);

        mainmodel = new Mainmodel(new Main("jack", "Toni"));
        list.add(mainmodel);



        observable = Observable.create(new ObservableOnSubscribe<List<Mainmodel>>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<List<Mainmodel>> emitter) throws Throwable {
                if (!emitter.isDisposed()) {
                    emitter.onNext(list);
                    emitter.onComplete();
                }
            }
        })
                .repeat(3) //-----repeating for display
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());


        observer = new Observer<List<Mainmodel>>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull List<Mainmodel> mainmodels) {
                Toast.makeText(CreateActivity.this, mainmodels.get(0).title1 + "" + mainmodels.get(0).title2,
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
        observable.subscribe(observer);




    }
}