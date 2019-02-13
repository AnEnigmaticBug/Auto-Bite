package com.bitecode.autobite.screens.shared.data.repo

import com.bitecode.autobite.screens.shared.core.User
import io.reactivex.Completable
import io.reactivex.Maybe

interface UserRepository {

    fun getUser(): Maybe<User>

    /**
     * Pass in  null to log-out the user.
     * */
    fun setUser(user: User?): Completable
}