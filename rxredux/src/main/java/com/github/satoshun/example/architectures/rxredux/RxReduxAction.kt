package com.github.satoshun.example.architectures.rxredux

sealed class RxReduxAction {
  object LoadFirstPageAction : RxReduxAction()
}
