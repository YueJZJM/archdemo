package com.yuejianzhong.archdemo.mvc

import com.yuejianzhong.archdemo.User
import com.yuejianzhong.archdemo.ICallback
import kotlin.random.Random

/**
 * 负责获取数据
 */
class MvcModule {
    fun getUserInfo(name: String,iCallback: ICallback) {
        if (Random.nextBoolean()) {
            val user = User("I am $name,mvc", 10)
            iCallback.onSuccess(user.toString())
        } else {
            iCallback.onFailed("错误")
        }
    }
}