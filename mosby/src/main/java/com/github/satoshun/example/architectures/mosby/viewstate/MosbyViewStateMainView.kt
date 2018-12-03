package com.github.satoshun.example.architectures.mosby.viewstate

import com.hannesdorfmann.mosby3.mvp.MvpView

interface MosbyViewStateMainView : MvpView {
  fun setUserName(name: String)
}
