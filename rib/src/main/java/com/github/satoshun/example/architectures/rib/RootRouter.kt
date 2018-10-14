package com.github.satoshun.example.architectures.rib

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.widget.TextView
import com.uber.rib.core.ViewRouter

class RootRouter(
  view: RootView,
  interactor: RootInteractor,
  component: RootBuilder.Component
) : ViewRouter<RootView, RootInteractor, RootBuilder.Component>(view, interactor, component) {
  fun attachView() {
    view.addView(view.context.getChildView())
  }
}

@SuppressLint("SetTextI18n")
private fun Context.getChildView(): TextView {
  return TextView(this)
      .apply {
        setTextColor(Color.BLACK)
        textSize = 30f
        text = "CHILD"
      }
}
