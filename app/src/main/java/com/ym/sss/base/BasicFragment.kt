package com.ym.sss.base

import android.view.View
import androidx.annotation.LayoutRes
import androidx.annotation.NonNull


abstract class BasicFragment : androidx.fragment.app.Fragment() {

    @LayoutRes
    protected abstract fun layoutRes(): Int

    protected abstract fun onInitView(@NonNull v: View)

    protected abstract fun onSetListener(@NonNull v: View)

    protected abstract fun onRequestData()

    override fun onDestroy() {
        super.onDestroy()
    }
}