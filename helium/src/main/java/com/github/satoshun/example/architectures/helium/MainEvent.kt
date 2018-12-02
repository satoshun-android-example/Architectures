package com.github.satoshun.example.architectures.helium

import com.joaquimverges.helium.core.event.ViewEvent

sealed class MainEvent : ViewEvent {
  object ClickSubmit : MainEvent()
}
