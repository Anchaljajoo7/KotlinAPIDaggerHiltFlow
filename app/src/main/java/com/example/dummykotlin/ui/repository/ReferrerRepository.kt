package com.example.dummykotlin.ui.repository

import com.example.dummykotlin.network.APIInterface
import com.example.dummykotlin.ui.model.GetReffereListResponse
import com.example.dummykotlin.utils.APIResponseCallback
import com.example.dummykotlin.utils.getServerError
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.HttpException
import javax.inject.Inject

class ReferrerRepository @Inject constructor(private val apiInterface: APIInterface) {

    fun getReffereListAPI(
        origin: String,
        token: String,
        hashMap: HashMap<String, String>,
        DOWNLOAD_REPORT_URL: String,
        s: String
    ): Flow<APIResponseCallback<GetReffereListResponse>> = flow {

        emit(APIResponseCallback.Loading())
        emit(
            APIResponseCallback.success(
                apiInterface.getList(
                    hashMap, token, origin, origin, DOWNLOAD_REPORT_URL, s

                )
            )
        )

    }.catch { e ->
        val errorMessage = when (e) {
            is HttpException -> {
                getServerError(e.code(), e.response()?.errorBody())
            }

            else -> "Failed: ${e.message}"
        }
        emit(APIResponseCallback.failed(errorMessage.toString()))

    }.flowOn(Dispatchers.IO)



}