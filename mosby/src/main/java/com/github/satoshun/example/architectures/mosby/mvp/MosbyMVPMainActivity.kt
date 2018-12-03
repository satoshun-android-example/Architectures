package com.github.satoshun.example.architectures.mosby.mvp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.github.satoshun.example.architectures.mosby.viewstate.MosbyViewStateMainActivity
import com.hannesdorfmann.mosby3.mvp.MvpActivity
import kotlinx.android.synthetic.main.mosby_mvp_main_act.*

class MosbyMVPMainActivity : MvpActivity<MosbyMainView, MosbyMainPresenter>(),
  MosbyMainView {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.mosby_mvp_main_act)

    submit.setOnClickListener {
      presenter.clickedSubmit()
    }

    state.setOnClickListener {
      startActivity(
        Intent(
          this@MosbyMVPMainActivity,
          MosbyViewStateMainActivity::class.java
        )
      )
    }
  }

  override fun createPresenter(): MosbyMainPresenter {
    return MosbyMainPresenter()
  }

  override fun showToast() {
    Toast
      .makeText(this, "test", Toast.LENGTH_SHORT)
      .show()
  }
}
