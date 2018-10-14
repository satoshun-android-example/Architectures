package com.github.satoshun.example.architectures.rib

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout

class RootView @JvmOverloads constructor(
  context: Context,
  attrs: AttributeSet? = null,
  defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr), RootInteractor.Presenter
