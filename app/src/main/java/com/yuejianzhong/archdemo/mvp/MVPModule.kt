package com.yuejianzhong.archdemo.mvp

import com.yuejianzhong.archdemo.User
import com.yuejianzhong.archdemo.ICallback
import kotlin.random.Random


/**
 * 负责获取数据
 */
class MVPModule {
    fun getUserInfo(name: String,callback: ICallback) {
        if (Random.nextBoolean()) {
            val user = User("i am $name,mvp", 30)
            callback.onSuccess(user.toString())
        }else{
            callback.onFailed("失败")
        }

    }
}