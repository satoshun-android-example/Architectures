package com.github.satoshun.example.architectures.helium

import com.joaquimverges.helium.core.presenter.BasePresenter
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import java.util.concurrent.TimeUnit

class MainPresenter : BasePresenter<MainState, MainEvent>() {
  override fun onViewEvent(event: MainEvent) {
    when (event) {
      MainEvent.ClickSubmit -> {
        Completable
          .timer(3000, TimeUnit.MILLISECONDS)
          .doOnSubscribe { pushState(MainState.Loading) }
          .observeOn(AndroidSchedulers.mainThread())
          .subscribe { pushState(MainState.Loaded) }
          .autoDispose()
      }
    }
  }
}
