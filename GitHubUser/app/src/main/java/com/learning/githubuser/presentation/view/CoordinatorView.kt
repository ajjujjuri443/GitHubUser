package com.learning.githubuser.presentation.view

import java.net.URL

import com.learning.githubuser.presentation.presenter.UserListPresenter
import com.learning.githubuser.presentation.presenter.UserPresenter



interface CoordinatorView {
    fun init()
    fun openSearchView()
    fun openUserList(presenter: UserListPresenter)
    fun openUser(presenter: UserPresenter)
    fun openBrowser(url: URL)
    fun closeView()
    fun closeUser()
    val isUserOpened: Boolean
}
