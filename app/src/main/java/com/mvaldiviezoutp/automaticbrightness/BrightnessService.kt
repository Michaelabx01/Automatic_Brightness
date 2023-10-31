package com.mvaldiviezoutp.automaticbrightness

import android.content.ContentResolver
import android.content.Context
import android.database.ContentObserver
import android.net.Uri
import android.os.Handler
import android.provider.Settings
import android.widget.Toast

class BrightnessObserver(
    context: Context,
    handler: Handler
) : ContentObserver(handler) {

    private val contentResolver: ContentResolver = context.contentResolver
    private val context = context

    override fun onChange(selfChange: Boolean) {
        super.onChange(selfChange)

        val currentBrightness = getCurrentBrightness()
        val maxBrightness = 255

        // Verificar si el brillo se está reduciendo
        if (currentBrightness < maxBrightness) {
            // Muestra un Toast
            Toast.makeText(context, "El brillo se está reduciendo.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun getCurrentBrightness(): Int {
        return Settings.System.getInt(contentResolver, Settings.System.SCREEN_BRIGHTNESS, -1)
    }
}
