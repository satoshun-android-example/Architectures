package com.github.satoshun.example.architectures.mobius

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.spotify.mobius.EventSource
import com.spotify.mobius.First
import com.spotify.mobius.First.first
import com.spotify.mobius.Mobius
import com.spotify.mobius.MobiusLoop
import com.spotify.mobius.Next
import com.spotify.mobius.Update
import com.spotify.mobius.android.runners.MainThreadWorkRunner
import com.spotify.mobius.rx2.RxMobius
import io.reactivex.ObservableTransformer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.android.Main
import kotlin.coroutines.CoroutineContext

class MobiusActivity : AppCompatActivity(),
    CoroutineScope {

  private val job = Job()
  override val coroutineContext: CoroutineContext get() = job + Dispatchers.Main

  private lateinit var controller: MobiusLoop.Controller<MobiusMainModel, MobiusMainEvent>
  private val eventSource = DeferredEventSource<MobiusMainEvent>()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.main_act)

    controller = Mobius.controller(
        createLoop(eventSource, createEffectHandler(this)),
        MobiusMainModel(
            name = null
        ),
        MainThreadWorkRunner.create()
    )
  }

  private fun createEffectHandler(
    context: Context
  ): ObservableTransformer<MobiusMainEffect, MobiusMainEvent> {
    return RxMobius
        .subtypeEffectHandler<MobiusMainEffect, MobiusMainEvent>()
        .build()
  }

  private fun createLoop(
    eventSource: EventSource<MobiusMainEvent>,
    effectHandler: ObservableTransformer<MobiusMainEffect, MobiusMainEvent>
  ): MobiusLoop.Factory<MobiusMainModel, MobiusMainEvent, MobiusMainEffect> {
    return RxMobius
        .loop(Update(::update), effectHandler)
        .init(::init)
        .eventSource(eventSource)
  }

  override fun onDestroy() {
    super.onDestroy()
    job.cancel()
  }
}

fun update(
  model: MobiusMainModel,
  event: MobiusMainEvent
): Next<MobiusMainModel, MobiusMainEffect> {
  return object : Next<MobiusMainModel, MobiusMainEffect>() {
    override fun effects(): MutableSet<MobiusMainEffect> {
      return mutableSetOf()
    }

    override fun model(): MobiusMainModel? {
      return model
    }
  }
}

fun init(model: MobiusMainModel): First<MobiusMainModel, MobiusMainEffect> {
  return first(model)
}
