package com.ym.sss.views

import android.content.Context
import android.util.AttributeSet
import android.view.TextureView

class SPlayerTexture : TextureView {
    constructor(context: Context) : this(context, null, 0)
    constructor(context: Context, @androidx.annotation.Nullable attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, @androidx.annotation.Nullable attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)
}