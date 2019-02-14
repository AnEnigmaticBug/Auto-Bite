package com.bitecode.autobite.screens.shared.data.repo

import android.content.SharedPreferences
import androidx.core.content.edit
import com.bitecode.autobite.screens.shared.core.User
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.schedulers.Schedulers

class UserRepositoryImpl(private val prefs: SharedPreferences) : UserRepository {

    init {
        setUser(User(267871, "Nishant Mahajan", 760))
            .subscribeOn(Schedulers.io())
            .subscribe()
    }

    override fun getUser(): Maybe<User> {
        val id = prefs.getLong("ID", 0L)
        val name = prefs.getString("NAME", null)
        val balance = prefs.getLong("BALANCE", 0L)

        if(id == 0L || name.isNullOrBlank()) {
            return Maybe.empty()
        }

        return Maybe.just(User(id, name, balance))
    }

    override fun setUser(user: User?): Completable {
        return Completable.create { emitter ->
            try {
                if(user == null) {
                    prefs.edit(commit = true) {
                        putLong("ID", 0L)
                        putString("NAME", null)
                        putLong("BALANCE", 0L)
                    }
                    emitter.onComplete()
                } else {
                    prefs.edit(commit = true) {
                        putLong("ID", user.id)
                        putString("NAME", user.name)
                        putLong("BALANCE", user.balance)
                    }
                    emitter.onComplete()
                }
            } catch(e: Exception) {
                emitter.onError(e)
            }
        }
    }
}