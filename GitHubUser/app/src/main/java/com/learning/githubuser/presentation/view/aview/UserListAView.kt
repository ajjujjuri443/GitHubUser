package  com.learning.githubuser.presentation.view.aview

//import android.support.v7.widget.LinearLayoutManager
//import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter
import jp.wasabeef.recyclerview.animators.LandingAnimator
import  com.learning.githubuser.R
import  com.learning.githubuser.domain.interactor.UserModel
import com.learning.githubuser.presentation.presenter.UserListPresenter
import com.learning.githubuser.presentation.utils.AView
import com.learning.githubuser.presentation.utils.AViewContainer
import com.learning.githubuser.presentation.view.UserListView
import com.learning.githubuser.presentation.view.view_etc.UserListAdapter
import com.learning.githubuser.presentation.viewholder.UserListViewHolder



class UserListAView(container: AViewContainer, private val presenter: UserListPresenter) : AView(container), UserListView {
    private val viewHolder: UserListViewHolder
    private var adapter: UserListAdapter? = null

    init {
        viewHolder = UserListViewHolder(parent)
        presenter.setView(this)
    }

    override fun getView(): ViewGroup {
        return viewHolder.recyclerView
    }

    override fun start() {
        presenter.start()
    }

    override fun init() {
        viewHolder.recyclerView.itemAnimator = LandingAnimator()
        val mLayoutManager = LinearLayoutManager(context)
        viewHolder.recyclerView.layoutManager = mLayoutManager
        viewHolder.recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (dy > 0) { //check for scroll down
                    val visibleItemCount = mLayoutManager.childCount
                    val totalItemCount = mLayoutManager.itemCount
                    val pastVisibleItems = mLayoutManager.findFirstVisibleItemPosition()
                    presenter.scrolled(visibleItemCount, totalItemCount, pastVisibleItems)
                }
            }
        })
        adapter = UserListAdapter(this)
        viewHolder.recyclerView.adapter = ScaleInAnimationAdapter(adapter)
    }

    override fun notifyUsersAdded(offset: Int, count: Int) {
        adapter!!.notifyItemsAdded(offset, count)
    }

    override fun clearList() {
        adapter!!.clearList()
    }

    override fun showLoadingError() {
        Toast.makeText(context, R.string.loading_error, Toast.LENGTH_SHORT).show()
    }

    override fun showParseError() {
        Toast.makeText(context, R.string.parse_error, Toast.LENGTH_LONG).show()
    }

    override fun showUnexpectedError() {
        Toast.makeText(context, R.string.unexpected_error, Toast.LENGTH_LONG).show()
    }

    override fun closeView() {

    }

    override fun hideLoading() {
        adapter!!.hideLoading()
    }

    override fun showLoading() {
        adapter!!.showLoading()
    }

    override fun notifyUserChanged(i: Int) {
        adapter!!.notifyNormalItemChanged(i)
    }

    fun getUserAt(i: Int): UserModel {
        return presenter.getUserAt(i)
    }

    val userCount: Int
        get() = presenter.userCount

    fun onFavorIconClick(user: UserModel) {
        presenter.onFavorIconClick(user)
    }

    fun onUserClicked(user: UserModel) {
        presenter.onUserClicked(user)
    }
}
