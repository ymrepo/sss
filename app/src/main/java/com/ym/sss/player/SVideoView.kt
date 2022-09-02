package com.ym.sss.player

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.google.android.exoplayer2.Player
import com.ym.sss.R
import com.ym.sss.databinding.WidgetVideoViewBinding

class SVideoView :
    FrameLayout {

    private var mBinding: WidgetVideoViewBinding? = null
    private var mPlayer: SEXOPlayer? = null



    constructor(context: Context, attrs: AttributeSet) : this(context, attrs, 0)
    constructor(context: Context) : this(context, null, 0) {

    }

    constructor(context: Context, attrs: AttributeSet?, style: Int) : super(context, attrs, style) {
        val view = LayoutInflater.from(context).inflate(R.layout.widget_video_view, null)
        mBinding = WidgetVideoViewBinding.bind(view)
        addView(view)
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        Log.i("ymTest", "onDetachedFromWindow")
    }

    fun play(url: String) {
        mBinding?.viewTexture?.let {
            mPlayer = SEXOPlayer(context, it).apply {
                setPlayerListener(object : SEXOPlayer.PlayerListener {
                    override fun onSurfaceSizeChanged(width: Int, height: Int, ratio: Float) {
                        mBinding?.layoutAspect?.setAspectRatio(if (height == 0 || width == 0) 1f else width * ratio / height)
                    }

                    override fun onPlaybackStateChanged(playbackState: Int) {
                        if (playbackState == Player.STATE_BUFFERING) {
         

                        }
                    }
                })
                setUrl(url)
            }
        }
    }

}