package com.example.dummykotlin.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dummykotlin.databinding.RvListBinding
import com.example.dummykotlin.ui.model.GetReffereListResponse

class ReferrerAdapter(val context: Context, val list: GetReffereListResponse) :
    RecyclerView.Adapter<ReferrerAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: RvListBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RvListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.tvText.setText(list[position].displayname)

    }
}