package me.aurelion.x.mvvm.demo;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.widget.Toast;

import java.util.List;

import me.aurelion.x.mvvm.demo.databinding.ActivityMainBinding;
import me.aurelion.x.mvvm.view.activity.BaseActivity;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> {

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public int getVariableName() {
        return BR.vm;
    }

    @Override
    public void initView() {
        vm.ss.observe(this, ss -> Toast.makeText(MainActivity.this, "SS:" + (ss == null ? 0 : ss.size()), Toast.LENGTH_SHORT).show());
    }

    @Override
    public void initData() {
        vm.getData();
    }
}
