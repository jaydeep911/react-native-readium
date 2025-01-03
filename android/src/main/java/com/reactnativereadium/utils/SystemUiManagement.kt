package com.reactnativereadium.utils

import android.app.Activity
import android.view.View
import android.view.WindowInsets
import androidx.core.view.WindowInsetsCompat

// Using ViewCompat and WindowInsetsCompat does not work properly in all versions of Android
@Suppress("DEPRECATION")
/** Returns `true` if fullscreen or immersive mode is not set. */
private fun Activity.isSystemUiVisible(): Boolean {
    return this.window.decorView.systemUiVisibility and View.SYSTEM_UI_FLAG_FULLSCREEN == 0
}

// Using ViewCompat and WindowInsetsCompat does not work properly in all versions of Android
@Suppress("DEPRECATION")
/** Enable fullscreen or immersive mode. */
fun Activity.hideSystemUi() {
     
}

// Using ViewCompat and WindowInsetsCompat does not work properly in all versions of Android
@Suppress("DEPRECATION")
/** Disable fullscreen or immersive mode. */
fun Activity.showSystemUi() {
  
}

/** Toggle fullscreen or immersive mode. */
fun Activity.toggleSystemUi() {
    if (this.isSystemUiVisible()) {
        this.hideSystemUi()
    } else {
        this.showSystemUi()
    }
}

/** Set padding around view so that content doesn't overlap system UI */
fun View.padSystemUi(insets: WindowInsets, activity: Activity) =
    WindowInsetsCompat.toWindowInsetsCompat(insets, this)
        .getInsets(WindowInsetsCompat.Type.systemBars()).apply {
            setPadding(
                left,
                top,
                right,
                bottom
            )
        }

/** Clear padding around view */
fun View.clearPadding() =
    setPadding(0, 0, 0, 0)
