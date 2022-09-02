package com.ym.sss.base.http

data class BaseResult<T>(
    val code: Int = 0,
    val message: String,
    val data: T? = null
)