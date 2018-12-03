package com.github.satoshun.example.architectures.mvrx

import android.os.Bundle
import androidx.fragment.app.commitNow
import com.airbnb.mvrx.BaseMvRxActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

class MvRxMainActivity : BaseMvRxActivity(),
  CoroutineScope {

  private val job = Job()
  override val coroutineContext: CoroutineContext get() = job + Dispatchers.Main

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.mv_rx_main_act)

    if (savedInstanceState == null) {
      supportFragmentManager
        .commitNow {
          add(MvRxMainFragment(), "temp")
        }
    }
  }

  override fun onDestroy() {
    super.onDestroy()
    job.cancel()
  }
}
