package com.yuejianzhong.archdemo.coroutines

data class DataBean<T>(
    val errorMsg:String,
    val errorCode:Int,
    val data:List<T>
)

data class DataWX(
    val children:List<String>,
    val courseId:Int,
    val id:Int,
    val name:String,
    val order:Int,
    val parentChapterId:Int,
    val userControlSetTop:Boolean,
    val visible:Int
)