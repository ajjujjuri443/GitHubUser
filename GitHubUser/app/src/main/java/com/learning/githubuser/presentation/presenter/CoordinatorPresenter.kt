package  com.learning.githubuser.presentation.presenter

import com.learning.githubuser.SystemInterface
import java.net.URL

import  com.learning.githubuser.domain.interactor.MainInteractor
import  com.learning.githubuser.domain.usecase.UserUseCase
import  com.learning.githubuser.presentation.view.CoordinatorView



class CoordinatorPresenter(system: SystemInterface) {

    private val interactor: MainInteractor
    private var view: CoordinatorView? = null

    init {
        interactor = MainInteractor(this, system)
    }

    fun setView(view: CoordinatorView) {
        this.view = view
    }

    fun start() {
        view!!.init()
    }

    fun onSearchInput(text: String) {
        interactor.onSearchInput(text)
    }

    fun onStartButton() {
        view!!.openSearchView()
        view!!.openUserList(UserListPresenter(interactor.userListUseCase!!))
    }

    fun onOpenUser(useCase: UserUseCase) {
        view!!.openUser(UserPresenter(useCase))
    }

    fun openInBrowser(url: URL) {
        view!!.openBrowser(url)
    }

    fun onFavoritesMenuClick() {
        interactor.onFavoritesOpen()
    }

    fun onBackPressed() {
        if (view!!.isUserOpened)
            view!!.closeUser()
        else
            view!!.closeView()
    }
}
