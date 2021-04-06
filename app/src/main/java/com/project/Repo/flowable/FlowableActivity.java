package com.project.Repo.flowable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.Log;
import com.project.R;
import com.project.databinding.ActivityFlowableBinding;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;


public class FlowableActivity extends AppCompatActivity {

    private static final String TAG = "FlowableActivity";

    private ActivityFlowableBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_flowable);


        Flowable<Integer> flowable = Flowable.range(1, 100000000)
                .observeOn(Schedulers.computation())
                .onBackpressureBuffer();


        Observable<Integer> observable = flowable.toObservable();
        observable.subscribeOn(Schedulers.io())
                .observeOn(Schedulers.newThread())
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        //------Disposable d==Subscribes-------------
                    }

                    @Override
                    public void onNext(@NonNull Integer integer) {
                        Log.e(TAG, "onNext: " + integer);
                        //----this log run without error------
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }
}