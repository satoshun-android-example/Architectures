package com.github.satoshun.example.architectures.mvicore

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.badoo.mvicore.android.AndroidBindings
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.android.Main
import kotlin.coroutines.CoroutineContext

class MviCoreMainActivity : AppCompatActivity(),
    CoroutineScope {

  private val job = Job()
  override val coroutineContext: CoroutineContext get() = job + Dispatchers.Main

  private lateinit var bindings: MainActivityBindings

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.main_act)

    bindings.setup(this)
  }

  override fun onDestroy() {
    super.onDestroy()
    job.cancel()
  }
}

class MainActivityBindings(
  view: MviCoreMainActivity
) : AndroidBindings<MviCoreMainActivity>(view) {
  override fun setup(view: MviCoreMainActivity) {
  }
}
