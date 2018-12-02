package com.github.satoshun.example.architectures.rxredux

import androidx.lifecycle.MutableLiveData
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.PublishSubject

class RxReduxMainViewModel(
  stateMachine: PaginationStateMachine = PaginationStateMachine()
) {
  private val disposables = CompositeDisposable()

  private val input = PublishSubject.create<RxReduxAction>()
  val state: MutableLiveData<PaginationStateMachine.State> = MutableLiveData()

  init {
    input.subscribe(stateMachine.input)
    disposables.add(stateMachine.state.subscribe { state.postValue(it) })
  }

  fun preparedActivity() {
    input.onNext(RxReduxAction.LoadFirstPageAction)
  }

  fun loadMoreItem() {
    input.onNext(RxReduxAction.LoadNextPageAction)
  }
}
