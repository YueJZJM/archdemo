package com.yuejianzhong.archdemo.mvp

import com.yuejianzhong.archdemo.User
import com.yuejianzhong.archdemo.ICallback


/**
 * 连接 view 和 module 层
 */
class MVPPresenter(val view: IMVPView){
    fun getData(name:String) {
        mvpModule.getUserInfo(name,object : ICallback {
            override fun onSuccess(msg: String) {
                view.showSuccessPage(user = User(name,40))
            }

            override fun onFailed(msg: String) {
                view.showFailedPage()
            }
        })
    }

    private  val mvpModule by lazy {
        MVPModule()
    }


}