package com.yuejianzhong.archdemo.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.yuejianzhong.archdemo.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class WxarticleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wxarticle)

        GlobalScope.launch(Dispatchers.Main) {
            withContext(Dispatchers.IO){
                val dataBean = RetrofitClient.reqApi.getDatas().await()
                Log.d("yuejz",dataBean.toString())
            }
            //更新ui
        }
    }
}
