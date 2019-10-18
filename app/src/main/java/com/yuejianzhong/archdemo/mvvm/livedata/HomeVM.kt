package com.yuejianzhong.archdemo.mvvm.livedata

import android.util.DebugUtils
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.debug
import java.util.logging.Logger

class HomeVM : ViewModel() {
    private val refreshTrigger = MutableLiveData<Boolean>()
    private val api = WanApi.get()
    private val bannerList: LiveData<ApiResponse<List<BannerVO>>> = Transformations.switchMap(refreshTrigger) {
        //当refreshTrigger的值被设置时，bannerList
//        debug("a")
        Log.d("yjz.bannerList",refreshTrigger.value.toString())
        api.bannerList()

    }

    //去返回json数据的data字段
    val banners: LiveData<List<BannerVO>> = Transformations.map(bannerList) {
        it.data ?: ArrayList()
    }

    fun loadData() {
        refreshTrigger.value = true
    }
}