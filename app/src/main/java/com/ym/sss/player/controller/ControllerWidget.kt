package com.ym.sss.player.controller

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.TextView
import com.ym.sss.databinding.WidgetControllerBinding

class ControllerWidget : FrameLayout, IController {

    private var mBinding: WidgetControllerBinding? = null

    constructor(context: Context) : this(context, null, 0)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        mBinding = WidgetControllerBinding.inflate(LayoutInflater.from(context), this, false)
        addView(mBinding?.root)
    }

    override fun start() {
    }

    override fun pause() {

    }
}