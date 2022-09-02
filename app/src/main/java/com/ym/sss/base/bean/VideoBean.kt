package com.ym.sss.base.bean

data class VideoBean(
    var mediaId: String? = "",
    var duration: Long = 0,//时长
    var playUrl: List<SourceBean>? = null,    //视频源列表
)

data class SourceBean(
    //播放地址
    var playUrl: String? = null,
)