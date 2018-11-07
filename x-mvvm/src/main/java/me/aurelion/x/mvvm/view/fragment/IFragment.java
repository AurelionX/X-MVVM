package me.aurelion.x.mvvm.view.fragment;

import android.os.Bundle;

import me.aurelion.x.mvvm.view.IView;

/**
 * Fragment基础接口
 *
 * @author Leon (wshk729@163.com)
 * @date 2018/11/6
 */
public interface IFragment extends IView {

    /**
     * 初始化参数
     *
     * @param bundle Arguments
     */
    void initParam(Bundle bundle);

}
