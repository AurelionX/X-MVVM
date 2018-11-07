package me.aurelion.x.mvvm.viewmodel;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;

import com.uber.autodispose.AutoDisposeConverter;

/**
 * ViewModel基础接口
 *
 * @author Leon (wshk729@163.com)
 * @date 2018/11/6
 */
public interface IViewModel extends LifecycleObserver {

    /**
     * onAny
     *
     * @param owner LifecycleOwner
     * @param event Event
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    void onAny(LifecycleOwner owner, Lifecycle.Event event);

    /**
     * onCreate
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void onCreate();

    /**
     * onDestroy
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void onDestroy();

    /**
     * onStart
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    void onStart();

    /**
     * onStop
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    void onStop();

    /**
     * onResume
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    void onResume();

    /**
     * onPause
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    void onPause();

    /**
     * 设置生命周期持有者(Activity/Fragment)
     *
     * @param owner LifecycleOwner
     */
    void setLifecycleOwner(LifecycleOwner owner);

    /**
     * 获取AutoDisposeConverter，用于解决Android生命周期组件导致的RxJava内存泄漏
     *
     * @return AutoDisposeConverter
     */
    <T> AutoDisposeConverter<T> getConverter();
}
