package com.github.satoshun.example.architectures.rib

import com.uber.rib.core.Bundle
import com.uber.rib.core.Interactor

class RootInteractor : Interactor<RootInteractor.Presenter, RootRouter>() {
  interface Presenter

  override fun didBecomeActive(savedInstanceState: Bundle?) {
    super.didBecomeActive(savedInstanceState)
    router.attachView()
  }
}
