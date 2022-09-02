package com.ym.sss.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity


abstract class BasicActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
    }


    /**
     * 获取布局
     *
     * @return 布局资源
     */
    @LayoutRes
    protected abstract fun layoutRes(): Int


    /**
     * 初始化数据
     *
     * @return 是否继续
     */
    protected open fun onInitData(): Boolean = true

    /**
     * 初始化View
     */
    protected abstract fun onInitView()

    /**
     * 设置监听
     */
    protected abstract fun onSetListener()

    /**
     * 请求网络数据
     */
    protected abstract fun onRequestData()


    open fun onClick(v: View) {}

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable("android:support:fragments", null)
    }
}