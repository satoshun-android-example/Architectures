package com.github.satoshun.example.architectures.helium

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.joaquimverges.helium.core.retained.RetainedPresenters
import kotlinx.android.synthetic.main.helium_main_act.*

class HeliumMainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.helium_main_act)

    val presenter = RetainedPresenters.get(this, MainPresenter::class.java)
    val delegate = MainViewDelegate(root)

    presenter.attach(delegate)
  }
}
