package com.github.satoshun.example.architectures.mvicore

sealed class UiEvent {
  data class ButtonClicked(val idx: Int) : UiEvent()
  object PlusClicked : UiEvent()
  object ImageClicked : UiEvent()
}
