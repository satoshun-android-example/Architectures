package com.github.satoshun.example.architectures.mosby.viewstate

import android.os.Bundle
import com.github.satoshun.example.architectures.mosby.mvp.R
import com.hannesdorfmann.mosby3.mvp.viewstate.MvpViewStateActivity
import kotlinx.android.synthetic.main.mosby_view_state_main_act.*

class MosbyViewStateMainActivity :
  MvpViewStateActivity<MosbyViewStateMainView, MosbyViewStatePresenter, MosbyMainViewState>(),
  MosbyViewStateMainView {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.mosby_view_state_main_act)

    submit.setOnClickListener {
      setViewState(viewState.apply { name = "submitted" })
      setUserName(viewState.name)
    }
  }

  override fun setUserName(name: String) {
    condition.text = name
  }

  override fun onNewViewStateInstance() {
  }

  override fun createPresenter(): MosbyViewStatePresenter {
    return MosbyViewStatePresenter()
  }

  override fun createViewState(): MosbyMainViewState {
    return MosbyMainViewState()
  }
}
