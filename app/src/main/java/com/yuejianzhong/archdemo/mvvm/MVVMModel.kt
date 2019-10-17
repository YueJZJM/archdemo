package com.yuejianzhong.archdemo.mvvm

import com.yuejianzhong.archdemo.ICallback
import com.yuejianzhong.archdemo.User
import kotlin.random.Random

class MVVMModel {
    fun getUserInfo(name: String,callback: ICallback) {
        if (Random.nextBoolean()) {
            val user = User("i am $name,mvp", 30)
            callback.onSuccess(user.toString())
        }else{
            callback.onFailed("失败")
        }

    }
}