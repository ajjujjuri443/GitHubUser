package com.learning.githubuser.presentation.viewholder


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.CollapsingToolbarLayout

import com.learning.githubuser.R
import com.learning.githubuser.presentation.view.view_etc.ToolbarTitleMarginBugFix
import kotlinx.android.synthetic.main.user_info.view.*
import kotlinx.android.synthetic.main.user_layout.view.*


class UserViewHolder(parent: ViewGroup) {

    var main: ViewGroup
    var content: RecyclerView
    var header: ImageView
    var collapsingToolbarLayout: CollapsingToolbarLayout
    var toolbar: ToolbarTitleMarginBugFix
    var favorite: View
    var openInBrowser: View
    var back: Button
    var login: TextView

    var userInfo: ViewGroup
    var emailLayout: LinearLayout
    var email: TextView
    var bioLayout: LinearLayout
    var bio: TextView
    var companyLayout: LinearLayout
    var company: TextView
    var locationLayout: LinearLayout
    var location: TextView
    var createdTime: TextView
    var updatedTime: TextView

    init {
        main = LayoutInflater.from(parent.context).inflate(R.layout.user_layout, parent, false) as ViewGroup
        content = main.content
        header = main.header
        collapsingToolbarLayout = main.collapsing_toolbar
        toolbar = main.anim_toolbar
        favorite = main.favorite_button
        openInBrowser = main.open_in_browser
        back = main.back_btn
        userInfo = LayoutInflater.from(parent.context).inflate(R.layout.user_info, parent, false) as ViewGroup
        login = userInfo.login
        emailLayout = userInfo.email_layout
        email = emailLayout.email
        bioLayout = userInfo.bio_layout
        bio = bioLayout.bio
        companyLayout = userInfo.company_layout
        company = companyLayout.company
        locationLayout = userInfo.location_layout
        location = locationLayout.location
        createdTime = userInfo.created_time
        updatedTime = userInfo.updated_time
    }

}
