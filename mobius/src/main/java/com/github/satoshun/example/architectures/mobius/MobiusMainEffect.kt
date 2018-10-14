package com.github.satoshun.example.architectures.mobius

sealed class MobiusMainEffect {
  object RefreshTasks : MobiusMainEffect()
}
