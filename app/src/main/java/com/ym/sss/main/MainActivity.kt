package com.ym.sss.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ym.sss.R
import com.ym.sss.base.BaseActivity
import com.ym.sss.base.bean.ContentMediaBean
import com.ym.sss.base.bean.FeedBean
import com.ym.sss.base.bean.SourceBean
import com.ym.sss.base.bean.VideoBean
import com.ym.sss.databinding.ActivityMainBinding
import com.ym.sss.main.upnp.CtrlPoint
import com.ym.sss.main.viewmodel.MainViewModel

class MainActivity : BaseActivity<ActivityMainBinding>() {

    private var viewModel: MainViewModel? = null
    private var mAdapter: PlayListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun layoutRes(): Int = R.layout.activity_main

    override fun onInitView() {
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel?.load()


        mBinding?.recyclerView?.layoutManager = LinearLayoutManager(baseContext, RecyclerView.HORIZONTAL, true)
        mAdapter = PlayListAdapter()
        mBinding?.recyclerView?.adapter = mAdapter


    }

    override fun onSetListener() {

        val list = arrayListOf<FeedBean>()
        for (index in 0..10) {
            val content = ContentMediaBean("", 0, null, VideoBean("", 0L, arrayListOf<SourceBean>().apply { add(SourceBean("asset:///jinglebell.mp4")) }))
            list.add(FeedBean(0, content))
        }
        mAdapter?.addAll(list)
        mAdapter?.notifyItemRangeChanged(0, 10)
        mAdapter?.getItem(0)?.content?.video?.playUrl?.get(0)?.playUrl?.let {
            mBinding?.widgetVideoView?.play(it)
        }

        mBinding?.btnScreencast?.setOnClickListener {
            startActivity(Intent(baseContext, ControlActivity::class.java))
        }

    }

    override fun onRequestData() {

    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) hideSystemUI()
    }

    private fun hideSystemUI() {
        // Enables regular immersive mode.
        // For "lean back" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
        // Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_IMMERSIVE
                // Set the content to appear under the system bars so that the
                // content doesn't resize when the system bars hide and show.
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                // Hide the nav bar and status bar
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN)
    }
}