package com.github.satoshun.example.architectures.rib

import com.uber.rib.core.Interactor

class RootInteractor : Interactor<RootInteractor.Presenter, RootRouter>() {
  interface Presenter {
  }
}
