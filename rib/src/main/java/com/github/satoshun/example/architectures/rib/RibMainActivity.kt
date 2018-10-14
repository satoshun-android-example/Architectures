package com.github.satoshun.example.architectures.rib

import android.view.ViewGroup
import com.uber.rib.core.RibActivity
import com.uber.rib.core.ViewRouter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.android.Main
import kotlin.coroutines.CoroutineContext

class RibMainActivity : RibActivity(),
    CoroutineScope {

  private val job = Job()
  override val coroutineContext: CoroutineContext get() = job + Dispatchers.Main

  override fun createRouter(parentViewGroup: ViewGroup): ViewRouter<*, *, *> {
    val builder = RootBuilder(object : RootBuilder.ParentComponent {})
    return builder.build(parentViewGroup)
  }

  override fun onDestroy() {
    super.onDestroy()
    job.cancel()
  }
}
