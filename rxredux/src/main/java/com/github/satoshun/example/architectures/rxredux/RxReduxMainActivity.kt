package com.github.satoshun.example.architectures.rxredux

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.main_act.*

class RxReduxMainActivity : AppCompatActivity() {
  private lateinit var viewModel: RxReduxMainViewModel

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.main_act)

    viewModel = RxReduxMainViewModel()

    viewModel.state.observe(this, Observer { state ->
      // render
      when (state) {
        PaginationStateMachine.State.LoadingFirstPageState -> root.addView(TextView(this@RxReduxMainActivity).apply {
          setText(R.string.first)
        })
        is PaginationStateMachine.State.ShowContentAndLoadNextPageState -> root.addView(TextView(this@RxReduxMainActivity).apply {
          text = state.text
        })
      }
    })

    viewModel.loadMoreItem()
    viewModel.preparedActivity()
  }
}
