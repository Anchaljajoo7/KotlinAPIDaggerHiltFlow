package com.example.dummykotlin.utils

import com.google.gson.annotations.SerializedName

data class ErrorResponse(
    @SerializedName ("status") var status:Boolean?=null,
    @SerializedName("message") var message:String?=null,
    @SerializedName("error") var error:String?=null
)
