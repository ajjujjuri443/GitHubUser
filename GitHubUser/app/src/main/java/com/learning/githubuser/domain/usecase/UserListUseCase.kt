package com.learning.githubuser.domain.usecase

import com.learning.githubuser.domain.interactor.UserModel
import com.learning.githubuser.presentation.presenter.UserListPresenter



interface UserListUseCase {
    fun subscribe(presenter: UserListPresenter)
    fun updateList(limit: Int, offset: Int)
    fun openUser(user: UserModel)
    fun pushFavorite(user: UserModel)
}
