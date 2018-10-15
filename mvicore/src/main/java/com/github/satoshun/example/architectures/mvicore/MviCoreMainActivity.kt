package com.github.satoshun.example.architectures.mvicore

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.badoo.mvicore.android.AndroidBindings
import com.badoo.mvicore.binder.Connection
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.Observer
import io.reactivex.functions.Consumer
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.main_act.*

class MviCoreMainActivity : AppCompatActivity(),
    ObservableSource<UiEvent>,
    Consumer<ViewModel> {

  private val source = PublishSubject.create<UiEvent>()

  private lateinit var bindings: MainActivityBindings

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.main_act)

    bindings = MainActivityBindings(this, Feature1())
    bindings.setup(this)

    plus.setOnClickListener {
      source.onNext(UiEvent.PlusClicked)
    }
  }

  override fun subscribe(observer: Observer<in UiEvent>) {
    source.subscribe(observer)
  }

  override fun accept(vm: ViewModel) {
    Toast.makeText(this, vm.toString(), Toast.LENGTH_SHORT).show()
  }
}

class MainActivityBindings(
  view: MviCoreMainActivity,
  private val feature: Feature1
) : AndroidBindings<MviCoreMainActivity>(view) {
  override fun setup(view: MviCoreMainActivity) {
    binder.bind(
        Connection(
            from = Observable
                .wrap(feature)
                .map { ViewModel(it.counter) },
            to = view
        )
    )
    binder.bind(
        Connection(
            from = Observable
                .wrap(view)
                .map(UiEventTransformer1()),
            to = feature
        )
    )
  }
}

data class ViewModel(val counter: Int)
