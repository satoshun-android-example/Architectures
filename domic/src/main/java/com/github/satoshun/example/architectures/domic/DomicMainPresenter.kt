package com.github.satoshun.example.architectures.domic

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.plusAssign

class DomicMainPresenter(
  private val view: DomicContract.View,
  private val disposables: CompositeDisposable = CompositeDisposable()
) : Disposable by disposables {
  init {
    disposables +=
        view.submitButton.observe
            .clicks
            .switchMapCompletable { view.doSubmit() }
            .subscribe()
  }
}
