package com.ym.sss.base.http.api

import com.ym.sss.base.bean.FeedBean
import com.ym.sss.base.http.BaseResult
import retrofit2.Call
import retrofit2.http.GET

interface FeedListApi {

    @GET("")
    fun getList(): Call<BaseResult<List<FeedBean>>>
}