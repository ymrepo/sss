package com.ym.sss.base.http

import retrofit2.Retrofit

class RetrofitManager {
    companion object {
        const val BASE_URL = ""
    }

    fun hh() {
        build(::a)
        build(::b)
    }

    fun build(funParam: (Int) -> String): Retrofit {
        val b = funParam(200)
        return Retrofit.Builder().baseUrl(BASE_URL).build()
    }

    fun test(): (Int) -> Boolean {
        return ::c
    }

    fun c(t: Int): Boolean {
        return t == 0
    }

    fun a(d: Int): String = "dd"
    fun b(d: Int): String = "dd$d"
}

