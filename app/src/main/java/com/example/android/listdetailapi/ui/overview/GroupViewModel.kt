package com.example.android.listdetailapi.ui.overview

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.listdetailapi.data.GroupDataSet
import com.example.android.listdetailapi.data.Result

class GroupViewModel: ViewModel() {
    private val groupDataSet = GroupDataSet()
    private val listData = MutableLiveData<Result>()

    init {
        getGroupList()
    }
    private fun getGroupList (){
        groupDataSet.getGroups(object:GroupDataSet.OnResultCallBack{
            override fun onResult(result: Result) {
                if(result is Result.Success){
                    listData.value = result
                }
            }
        })
    }
    fun getGroupListLiveData(): LiveData<Result> {
        return listData
    }

}