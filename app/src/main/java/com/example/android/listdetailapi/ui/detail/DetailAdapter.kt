package com.example.android.listdetailapi.ui.detail

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android.listdetailapi.R
import com.example.android.listdetailapi.model.Member
import com.squareup.picasso.Picasso

class DetailAdapter (private val context: Context)
    : RecyclerView.Adapter<DetailAdapter.ItemViewHolder>() {

    var groupList: List<Member> = emptyList()

    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val memberImage: ImageView = view.findViewById(R.id.iv_member)
        val memberName: TextView = view.findViewById(R.id.tv_name)
        val memberLastName: TextView = view.findViewById(R.id.tv_lastName)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.member_list, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        val item = groupList[position]
        holder.memberName.text = item.member_first_name
        holder.memberLastName.text = item.member_last_name
        Picasso.get()
            .load("http://download.runtastic.com/meetandcode/mobile_and_web_2016/images/members/${item.member_id}")
            .fit()
            .centerCrop()
            .into(holder.memberImage)

    }

    override fun getItemCount()= groupList.size

}