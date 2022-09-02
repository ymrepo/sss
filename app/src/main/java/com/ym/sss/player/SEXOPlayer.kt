package com.ym.sss.player

import android.content.Context
import android.net.Uri
import android.util.Log
import android.view.TextureView
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.video.VideoSize

class SEXOPlayer() : Player.Listener {

    private lateinit var mPlayer: ExoPlayer
    private var mListener: PlayerListener? = null

    interface PlayerListener {
        fun onSurfaceSizeChanged(width: Int, height: Int, ratio: Float)
        fun onPlaybackStateChanged(playbackState: Int)
    }

    constructor(context: Context, view: TextureView) : this() {
        val builder = ExoPlayer.Builder(context)
        mPlayer = builder.build()
        mPlayer.addListener(this)
        mPlayer.setVideoTextureView(view)
    }

    fun setUrl(url: String) {
        val mediaItem = MediaItem.fromUri(Uri.parse(url))
        mPlayer.setMediaItem(mediaItem);
        mPlayer.prepare()
        mPlayer.play()
    }

    override fun onVideoSizeChanged(videoSize: VideoSize) {
        super.onVideoSizeChanged(videoSize)
        mListener?.onSurfaceSizeChanged(videoSize.width, videoSize.height, videoSize.pixelWidthHeightRatio)
    }

    override fun onPlaybackStateChanged(playbackState: Int) {
        super.onPlaybackStateChanged(playbackState)
        mListener?.onPlaybackStateChanged(playbackState)
    }

    fun setPlayerListener(listener: PlayerListener) {
        mListener = listener
    }

    fun seekTo(position: Long) {
        mPlayer.seekTo(position)
    }

    fun getPosition(): Long {
        return mPlayer.currentPosition
    }

    fun release() {
        mPlayer.release()
    }
}