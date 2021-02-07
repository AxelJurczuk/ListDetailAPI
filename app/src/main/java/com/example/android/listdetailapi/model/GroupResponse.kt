package com.example.android.listdetailapi.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GroupResponse (val groups: List<Group>):Parcelable

@Parcelize
data class Group (val group_id:Int,
                  val group_name: String,
                  val members: List<Member>):Parcelable
@Parcelize
data class Member (val member_id: Int,
                   val member_first_name: String,
                   val member_last_name: String, ):Parcelable