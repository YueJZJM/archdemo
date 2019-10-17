package com.yuejianzhong.archdemo.normal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yuejianzhong.archdemo.ICallback
import com.yuejianzhong.archdemo.R
import com.yuejianzhong.archdemo.User
import kotlinx.android.synthetic.main.activity_normal.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import kotlin.random.Random

class NormalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_normal)

        bt_normal_login.onClick {
            val name = edit_normal_name.text.toString()
            name?.let {
                getUser(it,object : ICallback {
                    override fun onSuccess(msg: String) {
                        setUserInfo(msg)
                    }

                    override fun onFailed(msg: String) {
                        setUserInfo(msg)
                    }
                })
            }
        }
    }

    private fun setUserInfo(msg: String) {
        tv_normal_user.text = msg
    }

    private fun getUser(name: String,callback: ICallback) {
        if (Random.nextBoolean()) {
            val user = User("I am $name,mvc",19)
            callback.onSuccess(user.toString())
        } else {
            callback.onFailed("获取失败")
        }
    }


}
