package com.yuejianzhong.archdemo.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.yuejianzhong.archdemo.R
import com.yuejianzhong.archdemo.databinding.ActivityMvvmBinding

class MVVMActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding:ActivityMvvmBinding =
            DataBindingUtil.setContentView(this,R.layout.activity_mvvm)

        val viewModel = MVVMViewMode(application,binding)
    }
}
