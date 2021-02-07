package com.example.android.listdetailapi.data

import android.util.Log
import com.example.android.listdetailapi.model.GroupResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class GroupDataSet {

    fun getGroups(callBack:OnResultCallBack) {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://codingcontest.runtastic.com/mobile_and_web_2016/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        val api: ApiGroup = retrofit.create(ApiGroup::class.java)

        api.getGroups().enqueue(object : Callback<GroupResponse> {
            override fun onResponse(call: Call<GroupResponse>, response: Response<GroupResponse>) {

                if (response.isSuccessful) {

                    val groupResponse = response.body() ?: return
                    callBack.onResult(Result.Success(groupResponse.groups))

                } else {
                    callBack.onResult(Result.Failure("Something went wrong"))
                }
            }
            override fun onFailure(call: Call<GroupResponse>, t: Throwable) {
                callBack.onResult(Result.Failure(t.localizedMessage))
            }

        })
    }

    interface OnResultCallBack{
        fun onResult(result: Result)
    }


}