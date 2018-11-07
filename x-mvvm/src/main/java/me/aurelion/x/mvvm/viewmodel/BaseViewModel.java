package me.aurelion.x.mvvm.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.support.annotation.NonNull;

import com.uber.autodispose.AutoDispose;
import com.uber.autodispose.AutoDisposeConverter;
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider;

/**
 * @author Leon (wshk729@163.com)
 * @date 2018/11/6
 */
public class BaseViewModel extends AndroidViewModel implements IViewModel {

    protected LifecycleOwner owner;

    public BaseViewModel(@NonNull Application application) {
        super(application);
    }

    @Override
    public void onAny(LifecycleOwner owner, Lifecycle.Event event) {

    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void setLifecycleOwner(LifecycleOwner owner) {
        this.owner = owner;
    }

    @Override
    public <T> AutoDisposeConverter<T> getConverter() {
        return AutoDispose.autoDisposable(AndroidLifecycleScopeProvider.from(owner));
    }
}
