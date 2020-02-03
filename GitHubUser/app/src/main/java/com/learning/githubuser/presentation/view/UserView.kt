package com.learning.githubuser.presentation.view

import com.learning.githubuser.domain.github_repo.GitHubUser
import com.learning.githubuser.domain.interactor.UserModel



interface UserView {
    fun init()
    fun showWithAnimation()
    fun setUser(param: GitHubUser)
    fun setUser(userShort: UserModel)
    fun notifyReposUpdate(offset: Int, count: Int)
    fun closeView()
    fun showLoadingError()
    fun showParseError()
    fun showUnexpectedError()
    fun showUserLoading()
    fun hideUserLoading()
    fun showRepoLoading()
    fun hideRepoLoading()
}
