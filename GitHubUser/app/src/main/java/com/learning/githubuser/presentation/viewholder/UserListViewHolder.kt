package com.learning.githubuser.presentation.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.learning.githubuser.R



class UserListViewHolder(parent: ViewGroup) {

    var recyclerView: RecyclerView

    init {
        recyclerView = LayoutInflater.from(parent.context).inflate(R.layout.user_list_layout, parent, false) as RecyclerView
    }
}
