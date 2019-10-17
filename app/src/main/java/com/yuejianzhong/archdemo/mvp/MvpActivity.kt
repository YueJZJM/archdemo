package com.yuejianzhong.archdemo.mvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yuejianzhong.archdemo.R
import com.yuejianzhong.archdemo.User
import kotlinx.android.synthetic.main.activity_mvp.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class MvpActivity : AppCompatActivity(),IMVPView {

    private val mMvpPresenter by lazy {
        MVPPresenter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvp)

        bt_mvp_login.onClick {
            mMvpPresenter.getData(getUserInput())
        }
    }

    override fun getUserInput(): String {
        return edit_mvp_name.text.toString()
    }

    override fun showSuccessPage(user: User) {
        tv_mvp_user.text = user.toString()
    }

    override fun showFailedPage() {
        tv_mvp_user.text = "获取失败"
    }
}
