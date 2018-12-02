package com.github.satoshun.example.architectures.helium

import com.joaquimverges.helium.core.state.ViewState

sealed class MainState : ViewState {
  object Loaded : MainState()
  object Loading : MainState()
}
