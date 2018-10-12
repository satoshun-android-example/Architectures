package com.github.satoshun.example.architectures.rxredux

import com.freeletics.rxredux.StateAccessor
import com.freeletics.rxredux.reduxStore
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import java.util.concurrent.TimeUnit
import kotlin.random.Random
import kotlin.random.nextUInt

class PaginationStateMachine {
  sealed class State {
    object LoadingFirstPageState : State()

    data class ShowContentAndLoadNextPageState(val text: String) : State()
  }

  private val random = Random(100)

  val input = PublishSubject.create<RxReduxAction>()!!

  val state: Observable<State> = input
      .reduxStore(
          initialState = State.LoadingFirstPageState,
          sideEffects = listOf(::loadFirstPageSideEffect),
          reducer = ::reducer
      )
      .distinctUntilChanged()

  // like a api call and others
  private fun loadFirstPageSideEffect(
    actions: Observable<RxReduxAction>,
    state: StateAccessor<State>
  ): Observable<RxReduxAction> = actions
      .ofType(RxReduxAction.LoadNextPageAction::class.java)
      .delay(2000, TimeUnit.MILLISECONDS)
      .map {
        if (random.nextBoolean()) {
          RxReduxAction.LoadNextPageSuccessAction("${random.nextUInt()}sansan")
        } else {
          RxReduxAction.LoadNextPageErrorAction("Error")
        }
      }

  private fun reducer(state: State, action: RxReduxAction): State {
    return when (action) {
      RxReduxAction.LoadFirstPageAction -> state
      is RxReduxAction.LoadNextPageSuccessAction -> State.ShowContentAndLoadNextPageState(text = action.text)
      is RxReduxAction.LoadNextPageErrorAction -> State.ShowContentAndLoadNextPageState(text = action.errorMessage)
      else -> state
    }
  }
}
