package com.yuejianzhong.archdemo.mvvm.databinding

import com.yuejianzhong.archdemo.ICallback
import com.yuejianzhong.archdemo.User
import kotlin.random.Random

class MVVMModel {
    fun getUserInfo(name: String,callback: ICallback) {
        if (Random.nextBoolean()) {
            val user = User("i am $name,mvvm", 30)
            callback.onSuccess(user.toString())
        }else{
            callback.onFailed("失败")
        }

    }
}