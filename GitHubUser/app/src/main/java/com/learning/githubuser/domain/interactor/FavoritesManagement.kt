package com.learning.githubuser.domain.interactor

import com.learning.githubuser.SystemInterface
import java.util.ArrayList

import com.learning.githubuser.domain.github_repo.GitHubUserShort



class FavoritesManagement(private val system: SystemInterface) {

    private var favorites: ArrayList<UserModel>? = null

    private fun fillFavorites() {
        if (favorites != null) return
        val fav = system.getSavedStringArray(FAVORITES, Array<String>(0, {_->""}))
        favorites = ArrayList<UserModel>(fav.size)
        for (favor in fav) {
            val div = favor.split(divider.toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            favorites!!.add(UserModel(
                    Integer.parseInt(div[0]),
                    div[1],
                    true
            ))
        }
    }

    fun getFavorites(): ArrayList<UserModel> {
        fillFavorites()
        return favorites!!
    }

    fun isFavorite(user: GitHubUserShort): Boolean {
        fillFavorites()
        for (favor in favorites!!)
            if (favor.id == user.id) return true
        return false
    }

    fun sortFavorites(users: ArrayList<GitHubUserShort>): ArrayList<UserModel> {
        val ret = ArrayList<UserModel>(users.size)
        for (user in users) ret.add(UserModel(user, isFavorite(user)))
        return ret
    }

    fun addToFavorites(user: GitHubUserShort) {
        fillFavorites()
        favorites!!.add(0, UserModel(user, true))
        val fav = Array<String>(favorites!!.size, {i -> favorites!![i].id.toString() + divider + favorites!![i].login})
        system.saveStringArray(FAVORITES, fav)
    }

    fun removeFromFavorites(user: GitHubUserShort) {
        fillFavorites()
        val fav = ArrayList<String>()
        for (i in favorites!!.indices) {
            if (favorites!![i].id != user.id)
                fav.add(favorites!![i].id.toString() + divider + favorites!![i].login)
        }
        system.saveStringArray(FAVORITES, fav.toTypedArray())
        var i = 0
        while (i < favorites!!.size) {
            if (favorites!![i].id == user.id) favorites!!.removeAt(i--)
            i++
        }
    }

    companion object {

        val FAVORITES = "favorites"
        private val divider = "/"
    }

}
