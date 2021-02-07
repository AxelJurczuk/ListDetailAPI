package com.example.android.listdetailapi.ui.overview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android.listdetailapi.R
import com.example.android.listdetailapi.model.Group
import com.squareup.picasso.Picasso

class GroupAdapter (private val context: Context, private val clickListener:OnItemClick)
    : RecyclerView.Adapter<GroupAdapter.ItemViewHolder>() {

    var groupList: List<Group> = emptyList()

    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val groupImage: ImageView = view.findViewById(R.id.iv_group_image)
        val groupName: TextView = view.findViewById(R.id.tv_group_name)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        val item = groupList[position]
        holder.groupName.text = item.group_name

        Picasso.get()
            .load("http://download.runtastic.com/meetandcode/mobile_and_web_2016/images/groups/${item.group_id}")
            .fit()
            .centerCrop()
            .into(holder.groupImage)

        holder.itemView.setOnClickListener {
            clickListener.onItemClickListener(position)
        }
    }

    override fun getItemCount()= groupList.size

    interface OnItemClick {
        fun onItemClickListener (position: Int)
    }
}