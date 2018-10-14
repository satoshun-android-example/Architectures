package com.github.satoshun.example.architectures.mobius

sealed class MobiusMainEvent {
  object RefreshRequested : MobiusMainEvent()
}
