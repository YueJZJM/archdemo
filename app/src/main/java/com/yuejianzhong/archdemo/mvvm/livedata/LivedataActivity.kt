package com.yuejianzhong.archdemo.mvvm.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import cn.bingoogolapple.bgabanner.BGABanner
import com.yuejianzhong.archdemo.R
import com.yuejianzhong.archdemo.databinding.ActivityLivedataBinding

class LiveDataActivity : AppCompatActivity() {

    lateinit var binding: ActivityLivedataBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_livedata)
        val vm = ViewModelProviders.of(this).get(HomeVM::class.java)
        binding.lifecycleOwner = this
        binding.vm = vm
        initBanner()

//        binding.banner.addOnLayoutChangeListener()
//        binding.tvLivaDataLoaddata.addTextChangedListener()

    }

    private fun initBanner() {
        binding.run {
            val bannerAdapter = BGABanner.Adapter<ImageView, BannerVO> { _, image, model, _ ->
                image.displayWithUrl(model?.imagePath)
            }
            banner.setAdapter(bannerAdapter)
            vm?.banners?.observe(this@LiveDataActivity, Observer {
                Log.d("yjz.Observer",it.toString())
                banner.setData(it, null)
            })
        }
    }

}
