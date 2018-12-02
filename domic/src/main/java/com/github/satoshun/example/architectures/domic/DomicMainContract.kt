package com.github.satoshun.example.architectures.domic

import com.lyft.domic.api.Button
import io.reactivex.Completable

interface DomicMainContract {
  interface View {
    val submitButton: Button

    fun doSubmit(): Completable
  }
}
