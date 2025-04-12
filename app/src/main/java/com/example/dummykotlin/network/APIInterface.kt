package com.example.dummykotlin.network

import com.example.dummykotlin.ui.model.GetReffereListResponse
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Url

interface APIInterface
{
    @POST
    suspend fun getList(
        @Body hashMap: HashMap<String, String>,
        @Header("Authorization") token: String,
        @Header("Origin") origin: String,
        @Header("ris-origin") risOrigin: String,
        @Url url: String = "https://niwakdocb7.execute-api.us-east-1.amazonaws.com/Prod/ExamMgt",
        @Header("client-type") type: String = "mobile"

    ): GetReffereListResponse
}