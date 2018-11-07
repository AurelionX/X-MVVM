package me.aurelion.x.mvvm.view;

import android.support.annotation.LayoutRes;

/**
 * View基础接口
 *
 * @author Leon (wshk729@163.com)
 * @date 2018/11/6
 */
public interface IView {

    /**
     * 获取布局文件ID
     *
     * @return LayoutId
     */
    @LayoutRes
    int getLayoutId();

    /**
     * 获取绑定变量名（个人习惯取：BR.vm）
     *
     * @return VariableName
     */
    int getVariableName();

    /**
     * 初始化视图
     */
    void initView();

    /**
     * 初始化数据
     */
    void initData();
}
