package com.yuejianzhong.archdemo.mvvm.livedata

class ApiResponse<T>(
        var data: T?,
        var errorCode: Int,
        var errorMsg: String
)