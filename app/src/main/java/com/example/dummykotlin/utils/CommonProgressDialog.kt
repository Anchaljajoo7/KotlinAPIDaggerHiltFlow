package com.example.dummykotlin.utils

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Window
import android.widget.ProgressBar
import com.example.dummykotlin.R

class CommonProgressDialog(context: Context) : Dialog(context)  {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        getWindow()?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        setContentView(R.layout.custom_progress_dialog)
        var   progress_bar = findViewById<ProgressBar>(R.id.progress_bar)
        progress_bar
            .isIndeterminate = true
//        progress_bar.+ter(LightingColorFilter(-0x1000000, Color.parseColor("#FFFFFF")))

        setCanceledOnTouchOutside(false)
        setCancelable(false)
    }

//    fun show(context: Context) {
//        if (dialog == null) {
//            val inflater = LayoutInflater.from(context)
//            val view = inflater.inflate(R.layout.custom_progress_dialog, null)
//
//            val progressBar = view.findViewById<ProgressBar>(R.id.progress_bar)
//            progressBar.isIndeterminate = true
//
//            dialog = Dialog(context,R.style.CustomProgressDialog).apply {
//                setContentView(view)
//                setCancelable(false)
//                setCanceledOnTouchOutside(false)
//            }
//        }
//
//        dialog?.show()
//    }


}
