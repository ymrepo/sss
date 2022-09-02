package com.ym.sss.main.viewmodel

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ym.sss.MyApp
import com.ym.sss.main.upnp.CtrlPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.cybergarage.upnp.device.SearchResponseListener
import org.cybergarage.upnp.ssdp.SSDPPacket
import org.cybergarage.upnp.std.av.controller.MediaController

class ControlViewModel : ViewModel(), SearchResponseListener {
    var updateLiveData = MutableLiveData<SSDPPacket>()

    var point: CtrlPoint? = null
    fun startPoint() {
        viewModelScope.launch(Dispatchers.Main) {
            withContext(Dispatchers.IO) {
                point = CtrlPoint()
                point?.addSearchResponseListener(this@ControlViewModel)
                point?.start()
                point?.search()
            }
            updateLiveData.postValue(null)
        }
    }

    fun stop() {
        viewModelScope.launch {
            point?.stop()
        }
    }

    override fun deviceSearchResponseReceived(ssdpPacket: SSDPPacket?) {
        updateLiveData.postValue(ssdpPacket)
    }
}