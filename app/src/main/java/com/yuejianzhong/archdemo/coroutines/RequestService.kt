package com.yuejianzhong.archdemo.coroutines

import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface RequestService {
    @GET("wxarticle/chapters/json")
    fun getDatas() : Deferred<DataBean<DataWX>>
}