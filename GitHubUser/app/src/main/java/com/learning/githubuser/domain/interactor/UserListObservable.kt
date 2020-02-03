package com.learning.githubuser.domain.interactor

import java.io.IOException
import java.util.ArrayList

import com.learning.githubuser.domain.github_repo.ResponseParser
import com.learning.githubuser.domain.utils.Pair



abstract class UserListObservable(var query: String) {

    @Throws(IOException::class, ResponseParser.ParseException::class)
    abstract fun obtain(limit: Int, offset: Int): Pair<ArrayList<UserModel>, Int>

    override fun equals(other: Any?): Boolean {
        if (other !is UserListObservable) return false
        val compareWith = other
        return this.query == compareWith.query
    }
}
