package com.example.android.listdetailapi.data

import com.example.android.listdetailapi.model.GroupResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiGroup {

    @GET("groups.json")
    fun getGroups(): Call<GroupResponse>
}