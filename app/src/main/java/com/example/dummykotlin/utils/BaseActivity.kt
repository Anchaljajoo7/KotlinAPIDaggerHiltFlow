package com.example.dummykotlin.utils

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.dummykotlin.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
open class BaseActivity : AppCompatActivity() {
    lateinit var pdialog: CommonProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_base)
        pdialog = CommonProgressDialog(this@BaseActivity)
    }


    fun showLoader() {
        try {
            if (pdialog != null && !pdialog.isShowing) {
                pdialog.show()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun dismissLoader() {
        try {
            if (pdialog != null && pdialog.isShowing) {
                pdialog.dismiss()
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }

    }
}