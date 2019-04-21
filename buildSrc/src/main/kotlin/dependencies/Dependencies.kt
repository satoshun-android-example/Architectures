package dependencies

const val COMPILE_SDK = 28
const val MIN_SDK = 25
const val TARGET_SDK = 28

private const val VKOTLIN = "1.3.30"

const val ANDROID_PLUGIN = "com.android.tools.build:gradle:3.4.0"
const val KOTLIN_PLUGIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:$VKOTLIN"
const val VERSIONS_PLUGIN = "com.github.ben-manes:gradle-versions-plugin:0.20.0"

private const val VCOROUTINE = "1.2.0"
const val KOTLIN = "org.jetbrains.kotlin:kotlin-stdlib:$VKOTLIN"
const val COROUTINE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$VCOROUTINE"
const val UI_COROUTINE = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$VCOROUTINE"

const val KTX = "androidx.core:core-ktx:1.0.1"

const val ACTIVITYX = "androidx.activity:activity-ktx:1.0.0-alpha06"
const val FRAGMENTX = "androidx.fragment:fragment-ktx:1.1.0-alpha06"

const val APPCOMPAT = "androidx.appcompat:appcompat:1.0.2"
const val RECYCLERVIEW = "androidx.recyclerview:recyclerview:1.0.0"
const val CONSTRAINTLAYOUT = "androidx.constraintlayout:constraintlayout:2.0.0-alpha2"
const val CARDVIEW = "androidx.cardview:cardview:1.0.0"

const val MATERIAL = "com.google.android.material:material:1.0.0"
const val COORDINATORLAYOUT = "androidx.coordinatorlayout:coordinatorlayout:1.0.0"
const val PAGING = "androidx.paging:paging-runtime:2.0.0"
const val NAVIGATION = "android.arch.navigation:navigation-fragment-ktx:1.0.0"
const val NAVIGATION_UI = "android.arch.navigation:navigation-ui-ktx:1.0.0"

const val LIFECYLE_EXTENSION = "androidx.lifecycle:lifecycle-extensions:2.0.0"
const val VIEWMODEL = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.0.0"

const val LIVEDATA = "androidx.lifecycle:lifecycle-livedata:2.0.0"
const val LIFECYCLE_COMPILER = "androidx.lifecycle:lifecycle-compiler:2.0.0"

const val EMOJI = "androidx.emoji:emoji:1.0.0"
const val EMOJI_COMPAT = "androidx.emoji:emoji-appcompat:1.0.0"
const val EMOJI_BUNDLED = "androidx.emoji:emoji-bundled:1.0.0"

const val RXJAVA = "io.reactivex.rxjava2:rxjava:2.2.4"
const val RXANDROID = "io.reactivex.rxjava2:rxandroid:2.1.0"
const val RXKOTLIN = "io.reactivex.rxjava2:rxkotlin:2.3.0"
const val RXBINDING = "com.jakewharton.rxbinding3:rxbinding:3.0.0-alpha1"

const val RXREDUX = "com.freeletics.rxredux:rxredux:1.0.1"

const val MVRX = "com.airbnb.android:mvrx:1.0.0"

const val MOBIUS = "com.spotify.mobius:mobius-core:1.2.0"
const val MOBIUS_RX2 = "com.spotify.mobius:mobius-rx2:1.2.0"
const val MOBIUS_ANDROID = "com.spotify.mobius:mobius-android:1.2.0"

const val RIB = "com.uber.rib:rib-android:0.9.1"

const val MVICORE = "com.github.badoo.mvicore:mvicore:1.1.2"
const val MVICORE_ANDROID = "com.github.badoo.mvicore:mvicore-android:1.1.2"

const val MOSBY_MVP = "com.hannesdorfmann.mosby3:viewstate:3.1.0"
const val MOSBY_MVI = "com.hannesdorfmann.mosby3:mvi:3.1.0"

private const val VHELIUM = "0.2.1"
const val HELIUM_CORE = "com.joaquimverges.helium:helium-core:$VHELIUM"
const val HELIUM_UI = "com.joaquimverges.helium:helium-ui:$VHELIUM"

const val WORKFLOW_CORE = "com.squareup.workflow:workflow-core:0.1.0"

private const val VDAGGER = "2.22.1"
const val DAGGER = "com.google.dagger:dagger:$VDAGGER"
const val DAGGER_COMPILER = "com.google.dagger:dagger-compiler:$VDAGGER"

const val JUNIT = "junit:junit:4.12"
const val TRUTH = "com.google.truth:truth:0.39"
const val MOCKITO_KOTLIN = "com.nhaarman:mockito-kotlin-kt1.1:1.5.0"
const val TEST_RUNNER = "androidx.test:runner:1.1.0-alpha4"
const val ESPRESSO = "androidx.test.espresso:espresso-core:3.1.0-alpha4"
