package com.github.satoshun.example.architectures.rxredux

import com.freeletics.rxredux.reduxStore
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject

class PaginationStateMachine {

  sealed class State {
    object LoadingFirstPageState : State()
  }

  val input = PublishSubject.create<RxReduxAction>()

  val state: Observable<State> = input
      .reduxStore(
          initialState = State.LoadingFirstPageState,
          sideEffects = listOf(),
          reducer = ::reducer
      )
      .distinctUntilChanged()

  private fun reducer(state: State, action: RxReduxAction): State {
    return state
  }
}
