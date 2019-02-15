package com.bitecode.autobite.screens.shared.data.repo

import com.bitecode.autobite.screens.shared.core.Rickshaw
import io.reactivex.Flowable
import java.util.concurrent.TimeUnit

class RickshawRepositoryImpl : RickshawRepository {

    private val rickshaws = listOf(
        Rickshaw(1, "RJ 14 9816", 28.356761, 75.586629, 2),
        Rickshaw(2, "RJ 14 9161", 28.355773, 75.586105, 1),
        Rickshaw(3, "RJ 14 1881", 28.355515, 75.586851, 5)
    )

    override fun getRickshawsNearLocation(lat: Double, lng: Double): Flowable<List<Rickshaw>> {
        return Flowable.just(rickshaws)
            .delay(1, TimeUnit.SECONDS)
    }

    override fun callRickshaw(lat: Double, lng: Double): Flowable<Rickshaw> {
        return Flowable.just(rickshaws[0])
            .delay(3, TimeUnit.SECONDS)
    }
}