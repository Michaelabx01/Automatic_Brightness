package com.mvaldiviezoutp.automaticbrightness

import android.app.Service
import android.content.ContentResolver
import android.content.Context
import android.content.Intent
import android.database.ContentObserver
import android.net.Uri
import android.os.Handler
import android.os.IBinder
import android.provider.Settings
import android.widget.Toast

class BrightnessObserver : Service() {

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        // Set the screen brightness to the maximum value
        setBrightnessToMax()

        // Set the brightness mode to manual
        setBrightnessModeToManual()

        return super.onStartCommand(intent, flags, startId)
    }

    private fun setBrightnessToMax() {
        val contentResolver: ContentResolver = applicationContext.contentResolver
        Settings.System.putInt(contentResolver, Settings.System.SCREEN_BRIGHTNESS, 255)
    }

    private fun setBrightnessModeToManual() {
        val contentResolver: ContentResolver = applicationContext.contentResolver
        Settings.System.putInt(contentResolver, Settings.System.SCREEN_BRIGHTNESS_MODE, Settings.System.SCREEN_BRIGHTNESS_MODE_MANUAL)
    }
}