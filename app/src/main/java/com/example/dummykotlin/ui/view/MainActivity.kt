package com.example.dummykotlin.ui.view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dummykotlin.databinding.ActivityMainBinding
import com.example.dummykotlin.ui.adapter.ReferrerAdapter
import com.example.dummykotlin.ui.model.GetReffereListResponse
import com.example.dummykotlin.ui.viewmodel.ReferrerViewModel
import com.example.dummykotlin.utils.APIResponseCallback
import com.example.dummykotlin.utils.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : BaseActivity() {
    lateinit var binding: ActivityMainBinding
    val referrerViewModel: ReferrerViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        apiCall()
        attachObserver()
    }

    private fun apiCall() {

        val hashMap = HashMap<String, String>()
        hashMap["trigger"] = "getreffer"

        referrerViewModel.getReffereListAPI(
            "https://dineshtest.ablerispacs.com",
            "eyJraWQiOiJcL2tQdmN0bnZOVXZPaXdhR3Q4M2x5czd1XC9nQnkwQTFaS0xRNWM4WGZuYnM9IiwiYWxnIjoiUlMyNTYifQ.eyJzdWIiOiI0NGM4ZjRjOC1mMGMxLTcwZWEtYWE2MS0zZTEzNWQxY2IyNTIiLCJpc3MiOiJodHRwczpcL1wvY29nbml0by1pZHAudXMtZWFzdC0xLmFtYXpvbmF3cy5jb21cL3VzLWVhc3QtMV9iYXQyMXZhRVIiLCJjbGllbnRfaWQiOiI1dGJhODA0cjFsMGRqMG1xYjQxbHZ2cjhjbCIsIm9yaWdpbl9qdGkiOiIzMjhmYjI4Ny03NGJmLTRlYTEtYjllMS1hOGZhZDAzZjI4MWEiLCJldmVudF9pZCI6Ijc1M2FkMzQ1LWRlMmUtNGIzMi1iMzcyLTRlMWQ2MmY0NGM5MSIsInRva2VuX3VzZSI6ImFjY2VzcyIsInNjb3BlIjoiYXdzLmNvZ25pdG8uc2lnbmluLnVzZXIuYWRtaW4iLCJhdXRoX3RpbWUiOjE3NDQ0NjA5MDksImV4cCI6MTc0NDQ3MTcwOCwiaWF0IjoxNzQ0NDYwOTA5LCJqdGkiOiIwMGJkYzQzMC1kMGNhLTQ0ZjItODJjOS05YzcwMzE1NGYzNDUiLCJ1c2VybmFtZSI6IkFOQ0hBTFJFRiJ9.UfZHM1LvCJ9pjv4KUpwmmXKa7RR26LkybZWWzcATJlngFquo2L3jsQW0EEXCQEUOAcwnh43di-V27EyF8bDByHakVRd5TB-9LWSV1ya3oDCa7-feVrfPXnMVqDQflLGRSZiLrsucyfGqiQX9EV8ac2OADE59nLgWy5zJfu901NCd6nU05eDXG9DGymH71fzmDXfku9K9Jhu0Ofv2pARn6oiGAqifxXtuMtDpJ9eg5sMe96YUXZv0scCtY_5rIKk2r_KugjhE8WhbMdyFcptMlYpSgcbPKVHZ_TGNGsrdII4kgK9sv1T8kVr7QpL5rjEIso_wcDisNS1VZ_a1x2pY8w",
            hashMap,
            "https://niwakdocb7.execute-api.us-east-1.amazonaws.com/Prod/ExamMgt",
            "mobile"
        )

    }

    private fun attachObserver() {
        lifecycleScope.launch {
            referrerViewModel._reffereList.collect {
                when (it) {
                    is APIResponseCallback.Loading -> {
                        showLoader()
                        Toast.makeText(this@MainActivity, "Loading", Toast.LENGTH_SHORT).show()
                    }

                    is APIResponseCallback.Failed -> {
                        Toast.makeText(this@MainActivity, "Failed", Toast.LENGTH_SHORT).show()

                    }

                    is APIResponseCallback.Success -> {
                        dismissLoader()
                        Toast.makeText(this@MainActivity, "Success", Toast.LENGTH_SHORT).show()
                        if (it.data.size > 0) {
                            adapterSetup(it.data)
                        }
                    }

                    else -> {

                    }

                }

            }
        }

    }

    private fun adapterSetup(data: GetReffereListResponse) {
        val linearLayoutManager =
            LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
        binding.list.layoutManager = linearLayoutManager
        val referrerAdapter: ReferrerAdapter = ReferrerAdapter(this@MainActivity, data)
        binding.list.adapter = referrerAdapter
    }
}