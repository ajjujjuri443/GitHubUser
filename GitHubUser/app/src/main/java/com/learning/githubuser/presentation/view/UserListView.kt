package com.learning.githubuser.presentation.view



interface UserListView {

    fun init()
    fun notifyUsersAdded(offset: Int, count: Int)
    fun clearList()
    fun showLoadingError()
    fun showParseError()
    fun showUnexpectedError()
    fun closeView()
    fun hideLoading()
    fun showLoading()
    fun notifyUserChanged(i: Int)
}
