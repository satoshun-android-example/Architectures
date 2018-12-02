package com.github.satoshun.example.architectures.mosby.mvp

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter

class MosbyMainPresenter : MvpBasePresenter<MosbyMainView>() {
  fun clickedSubmit() {
    ifViewAttached {
      it.showToast()
    }
  }
}
