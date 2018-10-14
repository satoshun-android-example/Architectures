package com.github.satoshun.example.architectures.mvrx

import android.os.Bundle
import com.airbnb.mvrx.BaseMvRxActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.android.Main
import kotlin.coroutines.CoroutineContext

class MvRxActivity : BaseMvRxActivity(),
    CoroutineScope {

  private val job = Job()
  override val coroutineContext: CoroutineContext get() = job + Dispatchers.Main

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.main_act)

    if (savedInstanceState == null) {
      val manager = supportFragmentManager
      val fragment = MvRxMainFragment()
      manager
          .beginTransaction()
          .add(fragment, "temp")
          .commitNow()
    }
  }

  override fun onDestroy() {
    super.onDestroy()
    job.cancel()
  }
}
