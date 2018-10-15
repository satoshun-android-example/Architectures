package com.github.satoshun.example.architectures.mvicore

class UiEventTransformer1 : (UiEvent) -> Feature1.Wish {
  override fun invoke(event: UiEvent): Feature1.Wish = when (event) {
    is UiEvent.ButtonClicked -> Feature1.Wish.SetActiveButton(event.idx)
    is UiEvent.PlusClicked -> Feature1.Wish.IncreaseCounter
    is UiEvent.ImageClicked -> Feature1.Wish.IncreaseCounter
  }
}
