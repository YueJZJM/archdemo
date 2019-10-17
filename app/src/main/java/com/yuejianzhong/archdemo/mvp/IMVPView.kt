package com.yuejianzhong.archdemo.mvp

import com.yuejianzhong.archdemo.User

interface IMVPView {
    fun getUserInput():String
    fun showSuccessPage(user: User)
    fun showFailedPage()
}