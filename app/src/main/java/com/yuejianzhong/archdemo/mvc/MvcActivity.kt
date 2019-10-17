package com.yuejianzhong.archdemo.mvc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yuejianzhong.archdemo.R
import com.yuejianzhong.archdemo.ICallback
import kotlinx.android.synthetic.main.activity_mvc.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class MvcActivity : AppCompatActivity() {

    private val module by lazy {
        MvcModule()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvc)
        bt_mvc_login.onClick {
            val editName = edit_mvc_name.text.toString()
            module.getUserInfo(editName,object : ICallback {
                override fun onSuccess(msg: String) {
                    setUserInfo(msg)
                }

                override fun onFailed(msg: String) {
                    setUserInfo(msg)
                }
            })
        }
    }

    fun setUserInfo(msg: String) {
        tv_mvc_user.text = msg
    }
}
