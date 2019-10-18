package com.yuejianzhong.archdemo.mvvm.livedata

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.request.RequestOptions

fun ImageView.displayWithUrl(url: String?) {
    Glide.with(this).load(url)
            .apply(
                    RequestOptions().transforms(CenterCrop())
            )
            .into(this)
}

//fun ImageView.displayWithUrl(url: String?, radius: Float) {
//    val radiusPx = radius.dp2IntPx(context)
//    val empty = EmptyCornerDrawable(0xff969696.toInt(), radiusPx.toFloat())
//    Glide.with(this).load(url)
//            .apply(
//                    RequestOptions().transforms(
//                            CenterCrop(),
//                            RoundedCorners(radiusPx)
//                    )
//                            .placeholder(empty).error(
//                                    empty
//                            )
//            )
//            .into(this)
//}