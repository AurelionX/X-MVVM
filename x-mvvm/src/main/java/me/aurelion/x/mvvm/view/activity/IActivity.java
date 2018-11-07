package me.aurelion.x.mvvm.view.activity;

import android.content.Intent;

import me.aurelion.x.mvvm.view.IView;

/**
 * Activity基础接口
 *
 * @author Leon (wshk729@163.com)
 * @date 2018/11/6
 */
public interface IActivity extends IView {

    /**
     * 初始化参数
     *
     * @param intent Intent
     */
    void initParam(Intent intent);

}
