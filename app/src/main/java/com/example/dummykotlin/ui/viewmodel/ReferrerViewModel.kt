package com.example.dummykotlin.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dummykotlin.ui.model.GetReffereListResponse
import com.example.dummykotlin.ui.repository.ReferrerRepository
import com.example.dummykotlin.utils.APIResponseCallback
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ReferrerViewModel @Inject constructor(val referrerRepository: ReferrerRepository): ViewModel() {

    private val reffereList = MutableStateFlow<APIResponseCallback<GetReffereListResponse>?>(null)
    val _reffereList: StateFlow<APIResponseCallback<GetReffereListResponse>?> = reffereList

    fun getReffereListAPI(
        origin: String,
        token: String,
        hashMap: HashMap<String, String>,
        DOWNLOAD_REPORT_URL: String,
        s: String
    ) {

        viewModelScope.launch {

            referrerRepository.getReffereListAPI(origin,token,hashMap,DOWNLOAD_REPORT_URL,s).collect {

                reffereList.value = it
//                Log.d("Anchal", "getStadfff:: " + Gson().toJson(it))
            }

        }

    }


}