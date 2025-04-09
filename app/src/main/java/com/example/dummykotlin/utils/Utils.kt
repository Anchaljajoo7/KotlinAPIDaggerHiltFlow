package com.example.dummykotlin.utils

import android.util.Log
import com.google.gson.GsonBuilder
import okhttp3.ResponseBody

fun getServerError(responseCode: Int, responseBody: ResponseBody?): String? {
    var serverHandling = "Error $responseCode Please try Again"

    try {
        if (responseBody != null) {
            val gson = GsonBuilder().create()
            val commonStatusMessageResponseOne: ErrorResponse = gson.fromJson(
                responseBody.string(), ErrorResponse::class.java
            )

            commonStatusMessageResponseOne.message?.let {
                serverHandling = it
            }

            commonStatusMessageResponseOne.error?.let {
                serverHandling = it
            }

            if (responseCode == 401 /*&& serverHandling.lowercase().contains("token not authorized")*/) {
                serverHandling = serverHandling + "#" + "JwtTokenExpire"
                Log.d("222","~~~responseCode+~rr~~"+serverHandling)

            }
            return serverHandling
        }

    } catch (e: Exception) {
        e.printStackTrace()
    }
    return serverHandling
}