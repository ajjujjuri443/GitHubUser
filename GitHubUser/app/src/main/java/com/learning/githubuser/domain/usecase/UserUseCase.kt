package com.learning.githubuser.domain.usecase

import com.learning.githubuser.domain.github_repo.GitHubRepository
import com.learning.githubuser.domain.interactor.UserModel
import com.learning.githubuser.presentation.presenter.UserPresenter


interface UserUseCase {
    fun getUser(presenter: UserPresenter)
    val user: UserModel
    fun getRepositories(presenter: UserPresenter)
    fun getPinnedRepositories(presenter: UserPresenter)
    fun openInBrowser()
    fun notifyFavorChanged(userShort: UserModel)
    fun onRepoClick(repository: GitHubRepository)
}
