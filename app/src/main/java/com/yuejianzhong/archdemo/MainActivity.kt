package com.yuejianzhong.archdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yuejianzhong.archdemo.databinding.DemoActivity
import com.yuejianzhong.archdemo.mvc.MvcActivity
import com.yuejianzhong.archdemo.mvp.MvpActivity
import com.yuejianzhong.archdemo.mvvm.databinding.MVVMActivity
import com.yuejianzhong.archdemo.mvvm.livedata.LiveDataActivity
import com.yuejianzhong.archdemo.normal.NormalActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bt_normal_activity.onClick {
            startActivity<NormalActivity>()
        }

        bt_mvc_activity.onClick {
            startActivity<MvcActivity>()
        }

        bt_mvp_activity.onClick {
            startActivity<MvpActivity>()
        }

        bt_databinding_activity.onClick {
            startActivity<DemoActivity>()
        }

        bt_mvvm_activity.onClick {
            startActivity<MVVMActivity>()
        }

        bt_livedata_activity.onClick {
            startActivity<LiveDataActivity>()
        }
    }
}
