package com.github.satoshun.example.architectures.mobius

import com.spotify.mobius.EventSource
import com.spotify.mobius.disposables.Disposable
import com.spotify.mobius.functions.Consumer
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.atomic.AtomicBoolean

class DeferredEventSource<E> : EventSource<E> {
  private val events = LinkedBlockingQueue<E>()

  override fun subscribe(eventConsumer: Consumer<E>): Disposable {
    val run = AtomicBoolean(true)
    val t = Thread {
      while (run.get()) {
        try {
          val e = events.take()
          if (run.get()) {
            eventConsumer.accept(e)
          }
        } catch (e: InterruptedException) {
        }
      }
    }
    t.start()
    return Disposable {
      run.set(false)
      t.interrupt()
    }
  }

  @Synchronized fun notifyEvent(e: E) {
    events.offer(e)
  }
}
