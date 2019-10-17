package com.yuejianzhong.archdemo.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.yuejianzhong.archdemo.R
import com.yuejianzhong.archdemo.User
import org.jetbrains.anko.toast

class DemoActivity : AppCompatActivity() {

    private lateinit var binding:ActivityDemoBinding

    private lateinit var mUser:UserVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =
        DataBindingUtil.setContentView(this,R.layout.activity_demo)
        mUser = UserVM()
        mUser.age = 50
        mUser.name = "mvvm"
        binding.user = mUser
        binding.activity = this
    }

    fun onClick(view: View) {
        mUser.age = mUser.age +1

//        binding.user = mUser
    }
}
