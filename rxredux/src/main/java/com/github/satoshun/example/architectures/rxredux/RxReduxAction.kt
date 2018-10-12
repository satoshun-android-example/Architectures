package com.github.satoshun.example.architectures.rxredux

sealed class RxReduxAction {
  object LoadFirstPageAction : RxReduxAction()
  object LoadNextPageAction : RxReduxAction()

  data class LoadNextPageSuccessAction(
    val text: String
  ) : RxReduxAction()

  data class LoadNextPageErrorAction(
    val errorMessage: String
  ) : RxReduxAction()
}
