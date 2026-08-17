package com.example.hellostore

import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView

/**
 * Тестовое приложение для проверки конвейера релизов.
 * Показывает свою версию — по ней видно, что обновление действительно встало.
 */
class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            setBackgroundColor(Color.parseColor("#101418"))
            layoutParams = ViewGroup.LayoutParams(MATCH_PARENT, MATCH_PARENT)
            setPadding(48, 48, 48, 48)
        }

        root.addView(
            TextView(this).apply {
                text = getString(R.string.app_name)
                textSize = 28f
                gravity = Gravity.CENTER
                setTextColor(Color.WHITE)
            },
        )

        root.addView(
            TextView(this).apply {
                text = "версия ${BuildConfig.VERSION_NAME} (${BuildConfig.VERSION_CODE})"
                textSize = 20f
                gravity = Gravity.CENTER
                setTextColor(Color.parseColor("#8AB4F8"))
                setPadding(0, 24, 0, 0)
            },
        )

        setContentView(root)
    }

    private companion object {
        const val MATCH_PARENT = ViewGroup.LayoutParams.MATCH_PARENT
    }
}
