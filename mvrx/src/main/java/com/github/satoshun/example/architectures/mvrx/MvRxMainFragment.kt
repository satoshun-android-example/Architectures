package com.github.satoshun.example.architectures.mvrx

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.airbnb.mvrx.BaseMvRxFragment
import com.airbnb.mvrx.fragmentViewModel
import com.airbnb.mvrx.withState

class MvRxMainFragment : BaseMvRxFragment() {
  private val viewModel: MvRxMainViewModel by fragmentViewModel()

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.mv_rx_main_frag, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    viewModel.selectSubscribe(MainState::name) { name ->
      //      Toast.makeText(activity!!, name, Toast.LENGTH_SHORT).show()
    }
  }

  override fun invalidate() {
    withState(viewModel) { state ->
      Toast
        .makeText(activity!!, state.name, Toast.LENGTH_SHORT)
        .show()
    }
  }
}
