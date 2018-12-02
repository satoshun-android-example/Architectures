package com.github.satoshun.example.architectures.rxredux

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.main_act.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class RxReduxMainActivity : AppCompatActivity(),
  CoroutineScope {

  private val job = Job()
  override val coroutineContext: CoroutineContext get() = job + Dispatchers.Main

  private lateinit var viewModel: RxReduxMainViewModel

  @SuppressLint("SetTextI18n")
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.main_act)

    viewModel = RxReduxMainViewModel()

    viewModel.state.observe(this, Observer {
      // render
      when (
        val state = it) {
        PaginationStateMachine.State.LoadingFirstPageState -> root.addView(TextView(this@RxReduxMainActivity).apply {
          text = "first"
        })
        is PaginationStateMachine.State.ShowContentAndLoadNextPageState -> root.addView(TextView(this@RxReduxMainActivity).apply {
          text = state.text
        })
      }
    })

    launch {
      while (true) {
        delay(2000)
        viewModel.loadMoreItem()
      }
    }

    viewModel.preparedActivity()
  }

  override fun onDestroy() {
    super.onDestroy()
    job.cancel()
  }
}
