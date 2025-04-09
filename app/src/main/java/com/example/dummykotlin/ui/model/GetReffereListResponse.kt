package com.example.dummykotlin.ui.model


class GetReffereListResponse : ArrayList<GetReffereListResponse.ReffererResponseItem>(){
        data class ReffererResponseItem(
            val address_line1: String,
            val address_line2: String,
            val city: Any,
            val default_rad: String,
            val displayname: String,
            val firstname: String,
            val id: Int,
            val lastname: String,
            val notes: String,
            val state: Any
        )
    }
