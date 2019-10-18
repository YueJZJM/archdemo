package com.yuejianzhong.archdemo.mvvm.databinding

import android.app.Application
import android.util.Log
import android.view.View
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR
import com.yuejianzhong.archdemo.ICallback
import com.yuejianzhong.archdemo.databinding.ActivityMvvmBinding

/**
 * 数据获取， application 可用于网络，sp 等操作
 */
class MVVMViewMode(val application: Application,val binding: ActivityMvvmBinding):BaseObservable(){

    private val mvvmModel by lazy { MVVMModel() }

    @get:Bindable
    var result = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.result)
        }


//    @SingleClick
    fun loginClick(view: View) {
        Log.d("yuejz.getdata","getdata")
        val userInput = binding.editMvvmName.text.toString()
        Log.d("yuejz.userInput",userInput)
        mvvmModel.getUserInfo(userInput,object : ICallback {
            override fun onSuccess(msg: String) {
                result = msg
                Log.d("yuejz.onSuccess",result)
            }

            override fun onFailed(msg: String) {
                result = "失败"
                Log.d("yuejz.onSuccess",result)
            }
        })
    }

//    override fun onClick(v: View?) {
//        v?.let {
//            loginClick(it)
//        }
//    }

}