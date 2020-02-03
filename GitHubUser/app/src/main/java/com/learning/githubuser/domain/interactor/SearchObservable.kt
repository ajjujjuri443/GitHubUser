package com.learning.githubuser.domain.interactor

import com.learning.githubuser.SystemInterface
import java.io.IOException
import java.util.ArrayList

import com.learning.githubuser.domain.github_repo.GitHubRequests
import com.learning.githubuser.domain.github_repo.GitHubUserShort
import com.learning.githubuser.domain.github_repo.ResponseParser
import com.learning.githubuser.domain.utils.Pair



class SearchObservable(query: String,
                       private val system: SystemInterface,
                       private val favorites: FavoritesManagement) : UserListObservable(query) {

    @Throws(IOException::class, ResponseParser.ParseException::class)
    override fun obtain(limit: Int, offset: Int): Pair<ArrayList<UserModel>, Int> {
        val url = GitHubRequests.searchUser(query, limit, offset)
        val result = String(system.httpGet(url!!, null).t)
        val users = ResponseParser.parseSearchResults(result)
        return Pair(
                favorites.sortFavorites(users.t),
                if (users.u > 1000) 1000 else users.u)
    }
}
