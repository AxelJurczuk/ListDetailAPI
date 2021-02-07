package com.example.android.listdetailapi.data

import com.example.android.listdetailapi.model.Group
import com.example.android.listdetailapi.model.GroupResponse

sealed class Result {
    data class Success (var list: List<Group>):Result()
    data class Failure (val error: String):Result()
}