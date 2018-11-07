package me.aurelion.x.mvvm.demo;

import android.app.Application;
import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import me.aurelion.x.mvvm.viewmodel.BaseViewModel;

/**
 * @author Leon (wshk729@163.com)
 * @date 2018/11/6
 */
public class MainViewModel extends BaseViewModel {

    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    public ObservableField<String> info = new ObservableField<>("Hello World!");

    public MutableLiveData<String> msg = new MutableLiveData<>();

    public MutableLiveData<List<Integer>> ss = new MutableLiveData<>();

    public void getData() {
        Observable.timer(2000, TimeUnit.MILLISECONDS)
                .as(getConverter())
                .subscribe(aLong -> {
                    msg.postValue("AurelionX:X-MVVM");
                });
    }

    public void click() {
        int r = new Random().nextInt(10);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < r; i++) {
            list.add(i);
        }
        ss.postValue(list);
    }
}
