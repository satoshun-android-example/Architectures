package com.github.satoshun.example.architectures.mvicore

import com.badoo.mvicore.element.Reducer
import com.badoo.mvicore.feature.ReducerFeature

class Feature1 : ReducerFeature<Feature1.Wish, Feature1.State, Nothing>(
    initialState = State(),
    reducer = ReducerImpl()
) {
  data class State(
    val counter: Int = 0,
    val activeButtonIdx: Int? = null
  )

  sealed class Wish {
    object IncreaseCounter : Wish()
    data class SetActiveButton(val idx: Int) : Wish()
  }

  class ReducerImpl : Reducer<State, Wish> {
    override fun invoke(state: State, wish: Wish): State = when (wish) {
      Wish.IncreaseCounter -> state.copy(counter = state.counter + 1)
      is Wish.SetActiveButton -> state.copy(
          activeButtonIdx = if (wish.idx != state.activeButtonIdx) wish.idx else null
      )
    }
  }
}
