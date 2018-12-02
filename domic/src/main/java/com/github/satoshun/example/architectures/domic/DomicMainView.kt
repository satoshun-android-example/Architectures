package com.github.satoshun.example.architectures.domic

import android.view.ViewGroup
import android.widget.Toast
import com.lyft.domic.android.AndroidButton
import com.lyft.domic.api.Button
import com.lyft.domic.api.rendering.Renderer
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class DomicMainView(
  private val root: ViewGroup,
  private val renderer: Renderer
) : DomicMainContract.View {
  private val submit = root.findViewById<android.widget.Button>(R.id.submit)

  override val submitButton: Button = AndroidButton(
      submit,
      renderer
  )

  override fun doSubmit(): Completable {
    return Completable
        .timer(2000, TimeUnit.MILLISECONDS)
        .subscribeOn(Schedulers.io())
        .doOnSubscribe {
          submit.isEnabled = false
        }
        .subscribeOn(AndroidSchedulers.mainThread())
        .observeOn(AndroidSchedulers.mainThread())
        .doOnComplete {
          Toast
              .makeText(root.context, "Submitted!", Toast.LENGTH_SHORT)
              .show()
          submit.isEnabled = true
        }
  }
}
