package me.aurelion.x.mvvm.view.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import me.aurelion.x.mvvm.viewmodel.BaseViewModel;

/**
 * @author Leon (wshk729@163.com)
 * @date 2018/11/6
 */
public abstract class BaseActivity<V extends ViewDataBinding, VM extends BaseViewModel> extends AppCompatActivity implements IActivity {

    protected V bind;
    protected VM vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initParam(getIntent());
        initBind(savedInstanceState);
        initView();
        initData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        getLifecycle().removeObserver(vm);
        vm = null;
        bind.unbind();
    }

    protected void initBind(Bundle bundle) {
        Type type = getClass().getGenericSuperclass();
        Class vmClass;
        if (type instanceof ParameterizedType) {
            vmClass = (Class) ((ParameterizedType) type).getActualTypeArguments()[1];
        } else {
            vmClass = BaseViewModel.class;
        }
        vm = (VM) ViewModelProviders.of(this).get(vmClass);
        vm.setLifecycleOwner(this);

        bind = DataBindingUtil.setContentView(this, getLayoutId());
        bind.setLifecycleOwner(this);
        bind.setVariable(getVariableName(), vm);
        getLifecycle().addObserver(vm);
    }

    @Override
    public void initParam(Intent intent) {

    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }
}
