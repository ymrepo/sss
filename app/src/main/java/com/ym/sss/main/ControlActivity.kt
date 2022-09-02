package com.ym.sss.main

import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.ym.sss.R
import com.ym.sss.base.BaseActivity
import com.ym.sss.databinding.ActivityContrlBinding
import com.ym.sss.main.viewmodel.ControlViewModel

class ControlActivity : BaseActivity<ActivityContrlBinding>() {

    private lateinit var mViewModel: ControlViewModel
    override fun layoutRes(): Int = R.layout.activity_contrl

    override fun onInitView() {
        mViewModel = ViewModelProvider(this)[ControlViewModel::class.java]
        mViewModel.startPoint()
    }

    override fun onSetListener() {
        mBinding?.btnBack?.setOnClickListener { finish() }
        mViewModel.updateLiveData.observe(this) { packet ->
            run {
                if (packet != null) {
                    val uuid = packet.usn
                    val st = packet.st
                    val url = packet.location
                    Toast.makeText(baseContext, "uuid:$uuid st:$st url:$url .....", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    Toast.makeText(baseContext, "update.....", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onRequestData() {

    }

    override fun onDestroy() {
        super.onDestroy()
        mViewModel.stop()
    }
}