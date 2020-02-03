package com.learning.githubuser.domain.interactor

import com.learning.githubuser.SystemInterface
import java.io.IOException

import com.learning.githubuser.domain.github_repo.GitHubRepository
import com.learning.githubuser.domain.github_repo.GitHubUser
import com.learning.githubuser.domain.github_repo.GitHubUserShort
import com.learning.githubuser.domain.github_repo.ResponseParser
import com.learning.githubuser.domain.usecase.UserUseCase
import com.learning.githubuser.domain.utils.function
import com.learning.githubuser.presentation.presenter.UserPresenter



class UserInteractor(private val system: SystemInterface,
                     override val user: UserModel,
                     private val openInBrowser: (GitHubUserShort)->Unit,
                     private val onFavoriteChanged: (UserModel)->Unit,
                     private val openRepo: (GitHubRepository)->Unit) : UserUseCase {

    override fun getUser(presenter: UserPresenter) {
        system.doOnBackground(
                {
                    var callback: ()->Unit
                    try {
                        val url = user.url
                        val result = String(system.httpGet(url, null).t)
                        val user = ResponseParser.parseUser(result)
                        callback = { presenter.onUserReceived(user) }
                    } catch (e: IOException) {
                        e.printStackTrace()
                        callback = { presenter.showLoadingError() }
                    } catch (e: ResponseParser.ParseException) {
                        e.printStackTrace()
                        callback = { presenter.showParseError() }
                    } catch (e: Exception) {
                        e.printStackTrace()
                        callback = { presenter.showUnexpectedError() }
                    }
                    system.doOnForeground(callback)
                }
        )
    }

    override fun getRepositories(presenter: UserPresenter) {
        system.doOnBackground(
                {
                    var callback: ()-> Unit
                    try {
                        val url = user.repositories
                        val result = String(system.httpGet(url, null).t)
                        val repos = ResponseParser.parseRepositories(result)
                        callback = { presenter.onReposReceived(repos) }
                    } catch (e: IOException) {
                        e.printStackTrace()
                        callback = { presenter.showLoadingError() }
                    } catch (e: ResponseParser.ParseException) {
                        e.printStackTrace()
                        callback = { presenter.showParseError() }
                    } catch (e: Exception) {
                        e.printStackTrace()
                        callback = { presenter.showUnexpectedError() }
                    }

                    system.doOnForeground(callback)
                }
        )
    }

    override fun getPinnedRepositories(presenter: UserPresenter) {
        //TODO getPinnedRepositories
    }

    override fun openInBrowser() {
        openInBrowser(user)
    }

    override fun notifyFavorChanged(userShort: UserModel) {
        onFavoriteChanged(user)
    }

    override fun onRepoClick(repository: GitHubRepository) {
        openRepo(repository)
    }
}
