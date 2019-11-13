package com.yuejianzhong.archdemo.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.yuejianzhong.archdemo.R
import kotlinx.coroutines.*

class WxarticleActivity : AppCompatActivity() {

    val mainScope = MainScope()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wxarticle)

        val job = GlobalScope.launch(Dispatchers.Main) {
            withContext(Dispatchers.IO){
                val dataBean = RetrofitClient.reqApi.getDatas().await()
//                Log.d("yuejz",dataBean.toString())
            }
            //更新ui
        }

        mainScope.launch {
            val dataBean = RetrofitClient.reqApi.getDatas().await()
            Log.d("yuejz",dataBean.toString())
        }
//
//        GlobalScope.launch(Dispatchers.Main +CoroutineExceptionHandler { coroutineContext, throwable ->
//            print(throwable)
//        }) {
////            throw NullPointerException()
//        }
//        job.cancel()
    }

    override fun onDestroy() {
        super.onDestroy()
//        job
        mainScope.cancel()
    }
}
