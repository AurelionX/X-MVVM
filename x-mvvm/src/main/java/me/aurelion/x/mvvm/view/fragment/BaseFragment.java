package me.aurelion.x.mvvm.view.fragment;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import me.aurelion.x.mvvm.viewmodel.BaseViewModel;

/**
 * @author Leon (wshk729@163.com)
 * @date 2018/11/6
 */
public abstract class BaseFragment<V extends ViewDataBinding, VM extends BaseViewModel> extends Fragment implements IFragment {

    protected V bind;
    protected VM vm;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initParam(getArguments());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Type type = getClass().getGenericSuperclass();
        Class vmClass;
        if (type instanceof ParameterizedType) {
            vmClass = (Class) ((ParameterizedType) type).getActualTypeArguments()[1];
        } else {
            vmClass = BaseViewModel.class;
        }
        vm = (VM) ViewModelProviders.of(this).get(vmClass);
        vm.setLifecycleOwner(this);

        bind = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
        bind.setLifecycleOwner(this);
        bind.setVariable(getVariableName(), vm);
        getLifecycle().addObserver(vm);
        return bind.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        initData();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getLifecycle().removeObserver(vm);
        vm = null;
        bind.unbind();
    }

    @Override
    public void initParam(Bundle bundle) {

    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }
}
