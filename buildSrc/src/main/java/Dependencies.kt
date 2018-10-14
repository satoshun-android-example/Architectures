object Vers {
  const val compile_sdk = 28
  const val min_sdk = 26
  const val target_sdk = 28

  const val kotlin = "1.3.0-rc-57"
  const val coroutine = "0.30.0-eap13"
}

object Libs {
  const val android_plugin = "com.android.tools.build:gradle:3.2.1"
  const val kotlin_plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Vers.kotlin}"
  const val versions_plugin = "com.github.ben-manes:gradle-versions-plugin:0.20.0"

  const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Vers.kotlin}"
  const val coroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Vers.coroutine}"
  const val ui_coroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Vers.coroutine}"

  const val ktx = "androidx.core:core-ktx:1.0.0"

  const val appcompat = "androidx.appcompat:appcompat:1.0.0"
  const val recyclerview = "androidx.recyclerview:recyclerview:1.0.0"
  const val constraintlayout = "androidx.constraintlayout:constraintlayout:2.0.0-alpha2"
  const val cardview = "androidx.cardview:cardview:1.0.0"

  const val material = "com.google.android.material:material:1.0.0"
  const val coordinatorlayout = "androidx.coordinatorlayout:coordinatorlayout:1.0.0"
  const val paging = "androidx.paging:paging-runtime:2.0.0-rc01"
  const val navigation = "android.arch.navigation:navigation-fragment-ktx:1.0.0"
  const val navigation_ui = "android.arch.navigation:navigation-ui-ktx:1.0.0"

  const val viewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.0.0"
  const val livedata = "androidx.lifecycle:lifecycle-livedata:2.0.0"
  const val lifecycle_compiler = "androidx.lifecycle:lifecycle-compiler:2.0.0"

  const val emoji = "androidx.emoji:emoji:1.0.0"
  const val emoji_compat = "androidx.emoji:emoji-appcompat:1.0.0"
  const val emoji_bundled = "androidx.emoji:emoji-bundled:1.0.0"

  const val coroutine_binding = "com.github.satoshun.coroutinebinding:coroutinebinding:0.1.1"

  const val multidex = "com.android.support:multidex:1.0.3"

  const val rxjava = "io.reactivex.rxjava2:rxjava:2.2.0"
  const val rxandroid = "io.reactivex.rxjava2:rxandroid:2.1.0"
  const val rxkotlin = "io.reactivex.rxjava2:rxkotlin:2.3.0"
  const val rxbinding = "com.jakewharton.rxbinding2:rxbinding:2.2.0"

  const val rxredux = "com.freeletics.rxredux:rxredux:1.0.1"
  const val mvrx = "com.airbnb.android:mvrx:0.5.0"
  const val mobius = "com.spotify.mobius:mobius-core:1.2.0"
  const val mobius_rx2 = "com.spotify.mobius:mobius-rx2:1.2.0"
  const val mobius_android = "com.spotify.mobius:mobius-android:1.2.0"
  const val rib = "com.uber.rib:rib-android:0.9.1"

  const val junit = "junit:junit:4.12"
  const val truth = "com.google.truth:truth:0.39"
  const val mockito_kotlin = "com.nhaarman:mockito-kotlin-kt1.1:1.5.0"
  const val test_runner = "androidx.test:runner:1.1.0-alpha4"
  const val espresso = "androidx.test.espresso:espresso-core:3.1.0-alpha4"
}
