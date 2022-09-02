package com.ym.sss.base.bean

data class ContentMediaBean(
    val mediaId: String,
    val type: Int,
    val basic: MediaInfoBean? = null,
    val video: VideoBean
)

data class MediaInfoBean(
    val title: String? = null,//标题
    val des: String? = null//描述
)