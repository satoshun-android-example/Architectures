package com.github.satoshun.example.architectures.helium

import android.view.ViewGroup
import com.joaquimverges.helium.core.viewdelegate.BaseViewDelegate
import kotlinx.android.synthetic.main.helium_main_act.view.*

class MainViewDelegate(view: ViewGroup) : BaseViewDelegate<MainState, MainEvent>(view) {
  init {
    view.submit.setOnClickListener {
      pushEvent(MainEvent.ClickSubmit)
    }
  }

  override fun render(viewState: MainState) {
    val ignore = when (viewState) {
      MainState.Loaded -> {
        view.progress.hide()
      }
      MainState.Loading -> {
        view.progress.show()
      }
    }
  }
}
