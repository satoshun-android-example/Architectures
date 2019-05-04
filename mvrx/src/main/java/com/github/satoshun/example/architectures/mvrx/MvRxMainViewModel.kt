package com.github.satoshun.example.architectures.mvrx

import com.airbnb.mvrx.BaseMvRxViewModel
import com.airbnb.mvrx.MvRxState
import io.reactivex.Observable
import java.util.concurrent.TimeUnit
import kotlin.random.Random
import kotlin.random.nextUInt

data class MainState(
  val name: String? = null
) : MvRxState

class MvRxMainViewModel(state: MainState) : BaseMvRxViewModel<MainState>(
  initialState = state,
  debugMode = BuildConfig.DEBUG
) {
  private val random = Random(10)

  init {
    Observable.interval(5, TimeUnit.SECONDS)
      .map { random.nextUInt() }
      .execute {
        copy(name = it().toString())
      }
      .disposeOnClear()
  }
}
