package com.github.satoshun.example.architectures.mvrx

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.get
import com.airbnb.mvrx.BaseMvRxFragment

class MvRxMainFragment : BaseMvRxFragment() {
  private val viewModel: MvRxMainViewModel by lazy {
    ViewModelProviders.of(
        this,
        object : ViewModelProvider.Factory {
          override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return MvRxMainViewModel() as T
          }
        }
    ).get<MvRxMainViewModel>()
  }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.main_frag, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    viewModel.selectSubscribe(MainState::name) { name ->
      Toast.makeText(activity!!, name, Toast.LENGTH_SHORT).show()
    }
  }

  override fun invalidate() {
    // todo
  }
}
