package com.github.satoshun.example.architectures.mosby.viewstate

import android.os.Bundle
import com.hannesdorfmann.mosby3.mvp.viewstate.RestorableViewState

data class MosbyMainViewState(
  var name: String = "first"
) : RestorableViewState<MosbyViewStateMainView> {
  override fun apply(view: MosbyViewStateMainView, retained: Boolean) {
    view.setUserName(name)
  }

  override fun saveInstanceState(out: Bundle) {
    out.putString("name", name)
  }

  override fun restoreInstanceState(bundle: Bundle?): RestorableViewState<MosbyViewStateMainView>? {
    if (bundle == null) {
      return null
    }
    return copy(name = bundle.getString("name")!!)
  }
}
