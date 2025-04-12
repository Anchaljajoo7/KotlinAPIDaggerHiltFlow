package com.example.dummykotlin.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dummykotlin.databinding.RvListBinding
import com.example.dummykotlin.ui.model.GetReffereListResponse

class ReferrerAdapter(val context: Context, val list: GetReffereListResponse) :
    RecyclerView.Adapter<ReferrerAdapter.ViewHolder>() {

    private var filteredList: MutableList<GetReffereListResponse.ReffererResponseItem> = list.toMutableList()

    inner class ViewHolder(val binding: RvListBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RvListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = filteredList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        Log.d("Anchal", "onBindViewHolder: "+list.size)
        holder.binding.tvText.setText(filteredList[position].displayname)

    }

    fun filter(query: String) {
        filteredList = if (query.isEmpty()) {
            list.toMutableList()
        } else {
            list.filter {
                it.displayname.contains(query, ignoreCase = true)
            }.toMutableList()
        }
        notifyDataSetChanged()
    }
}