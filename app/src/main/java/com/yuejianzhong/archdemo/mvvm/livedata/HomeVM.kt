package com.yuejianzhong.archdemo.mvvm.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class HomeVM : ViewModel() {
    private val refreshTrigger = MutableLiveData<Boolean>()
    private val api = WanApi.get()
    private val bannerList: LiveData<ApiResponse<List<BannerVO>>> = Transformations.switchMap(refreshTrigger) {
        //当refreshTrigger的值被设置时，bannerList
        api.bannerList()
    }

    val banners: LiveData<List<BannerVO>> = Transformations.map(bannerList) {
        it.data ?: ArrayList()
    }

    fun loadData() {
        refreshTrigger.value = true
    }
}