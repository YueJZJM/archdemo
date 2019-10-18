package com.yuejianzhong.archdemo.mvvm.livedata

import androidx.lifecycle.LiveData
import com.yuejianzhong.archdemo.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.util.concurrent.TimeUnit

interface WanApi {
    companion object {
        fun get(): WanApi {
            val clientBuilder = OkHttpClient.Builder()
                    .connectTimeout(60, TimeUnit.SECONDS)
            if (BuildConfig.DEBUG) {
                val loggingInterceptor = HttpLoggingInterceptor()
                loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
                clientBuilder.addInterceptor(loggingInterceptor)
            }
            return Retrofit.Builder()
                    .baseUrl("https://www.wanandroid.com/")
                    .client(clientBuilder.build())
                    .addCallAdapterFactory(LiveDataCallAdapterFactory())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(WanApi::class.java)
        }
    }
    /**
     * 首页banner
     */
    @GET("banner/json")
    fun bannerList(): LiveData<ApiResponse<List<BannerVO>>>
}