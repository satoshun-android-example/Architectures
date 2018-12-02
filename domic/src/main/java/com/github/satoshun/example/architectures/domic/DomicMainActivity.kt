package com.github.satoshun.example.architectures.domic

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lyft.domic.android.rendering.AndroidRenderer
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign

class DomicMainActivity : AppCompatActivity() {

  private val renderer = AndroidRenderer()
  private val disposables = CompositeDisposable()

  @SuppressLint("SetTextI18n")
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.main_act)

    val view = DomicMainView(findViewById(android.R.id.content), renderer)
    disposables += DomicMainPresenter(view)
  }

  override fun onDestroy() {
    super.onDestroy()
    disposables.dispose()
  }
}
