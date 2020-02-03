package com.learning.githubuser.domain.interactor

import java.io.IOException
import java.util.ArrayList

import com.learning.githubuser.domain.github_repo.ResponseParser
import com.learning.githubuser.domain.utils.Pair



class FavoriteObservable(private val favorites: FavoritesManagement) : UserListObservable(FavoritesManagement.FAVORITES) {

    @Throws(IOException::class, ResponseParser.ParseException::class)
    override fun obtain(limit: Int, offset: Int): Pair<ArrayList<UserModel>, Int> {
        return Pair(favorites.getFavorites(), favorites.getFavorites().size)
    }
}
