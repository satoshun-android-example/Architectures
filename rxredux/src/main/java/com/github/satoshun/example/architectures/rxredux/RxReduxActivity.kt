package com.github.satoshun.example.architectures.rxredux

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer

class RxReduxActivity : AppCompatActivity() {

  private lateinit var viewModel: RxReduxViewModel

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.main_act)

    viewModel = RxReduxViewModel()

    viewModel.state.observe(this, Observer {
      // render
      when (it!!) {

      }
    })

    viewModel.input.onNext(RxReduxAction.LoadFirstPageAction)
  }
}
