package com.github.satoshun.example.architectures.rib

import android.view.LayoutInflater
import android.view.ViewGroup
import com.uber.rib.core.InteractorBaseComponent
import com.uber.rib.core.ViewBuilder
import dagger.Binds
import dagger.BindsInstance
import dagger.Provides

class RootBuilder(
  dependency: ParentComponent
) : ViewBuilder<RootView, RootRouter, RootBuilder.ParentComponent>(
    dependency
) {
  @dagger.Component(
      modules = [Module::class],
      dependencies = [ParentComponent::class]
  )
  interface Component : InteractorBaseComponent<RootInteractor>,
      BuilderComponent {
    @dagger.Component.Builder
    interface Builder {
      @BindsInstance
      fun interactor(interactor: RootInteractor): Builder

      @BindsInstance
      fun view(view: RootView): Builder

      fun parentComponent(component: ParentComponent): Builder
      fun build(): Component
    }
  }

  interface ParentComponent

  interface BuilderComponent {
    fun rootRouter(): RootRouter
  }

  fun build(parentView: ViewGroup): RootRouter {
    val rootView = createView(parentView)
    val interactor = RootInteractor()
    TODO()
  }

  override fun inflateView(inflater: LayoutInflater, parentViewGroup: ViewGroup): RootView {
    return RootView(parentViewGroup.context)
  }

  @dagger.Module
  abstract class Module {
    @Binds
    abstract fun presenter(view: RootView): RootInteractor.Presenter

    @dagger.Module
    companion object {
      @JvmStatic
      @Provides
      fun router(component: Component, view: RootView, interactor: RootInteractor): RootRouter {
        return RootRouter(
            view,
            interactor,
            component
        )
      }
    }
  }
}
