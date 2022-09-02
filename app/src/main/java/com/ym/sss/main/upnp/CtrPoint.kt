package com.ym.sss.main.upnp

import android.util.Log
import org.cybergarage.upnp.ControlPoint
import org.cybergarage.upnp.Device
import org.cybergarage.upnp.device.DeviceChangeListener
import org.cybergarage.upnp.device.NotifyListener
import org.cybergarage.upnp.device.SearchResponseListener
import org.cybergarage.upnp.event.EventListener
import org.cybergarage.upnp.ssdp.SSDPPacket


class CtrlPoint : ControlPoint(), NotifyListener, EventListener, DeviceChangeListener {


    init {
        addNotifyListener(this)
//        addSearchResponseListener(this)
        addEventListener(this)
        addDeviceChangeListener(this)
    }

    override fun deviceNotifyReceived(packet: SSDPPacket) {
        println(packet.toString())
        if (packet.isDiscover) {
            val st = packet.st
            Log.i("upnp", "deviceNotifyReceived->ssdp: discover : ST = $st string:${packet}")
        } else if (packet.isAlive) {
            val usn = packet.usn
            val nt = packet.nt
            val url = packet.location
            Log.i("upnp", "deviceNotifyReceived->ssdp:alive : uuid = $usn, NT = $nt, location = $url")
        } else if (packet.isByeBye) {
            val usn = packet.usn
            val nt = packet.nt
            Log.i("upnp", "deviceNotifyReceived->ssdp:byebye : uuid = $usn, NT = $nt")
        }
    }

    //    override fun deviceSearchResponseReceived(packet: SSDPPacket) {
//        val uuid = packet.usn
//        val st = packet.st
//        val url = packet.location
//        Log.i("upnp", "device search res : uuid = $uuid, ST = $st, location = $url")
//    }
    override fun eventNotifyReceived(uuid: String, seq: Long, name: String, value: String) {
        Log.i("upnp", "event notify : uuid = $uuid, seq = $seq, name = $name, value =$value")
    }

    override fun deviceAdded(dev: Device?) {
        Log.i("upnp", "deviceAdded")
        if ("urn:schemas-upnp-org:device:MediaRenderer:1" == dev?.deviceType) {
            deviceList.add(dev);
        }

    }

    override fun deviceRemoved(dev: Device?) {
        Log.i("upnp", "deviceRemoved")
    }

    fun play() {
// 实例ID
        val instanceID = "0"
// 播放视频地址
        val currentURI = "http://hc.yinyuetai.com/uploads/videos/common/026E01578953FD0EF0E47204247B5D13.flv?sc=2d17ae37a9186da6&br=780&vid=2693509&aid=623&area=US&vst=2";
        val device = deviceList[0] as Device
// 获取服务
        val service = device.getService("urn:schemas-upnp-org:service:AVTransport:1");
// 获取动作
        val transportAction = service.getAction("SetAVTransportURI");
// 设置参数
        transportAction.setArgumentValue("InstanceID", instanceID);
        transportAction.setArgumentValue("CurrentURI", currentURI);
// SetAVTransportURI
        if (transportAction.postControlAction()) {
            // 成功
            val playAction = service.getAction("Play");
            playAction.setArgumentValue("InstanceID", instanceID);
            // Play
            if (!playAction.postControlAction()) {
                Log.e("upnpErr", playAction.getStatus().getDescription());
            }
        } else {
            // 失败
            Log.e("upnpErr", transportAction.getStatus().getDescription());
        }
    }
}