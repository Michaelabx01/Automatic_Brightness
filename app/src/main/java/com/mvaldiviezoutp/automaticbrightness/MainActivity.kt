package com.mvaldiviezoutp.automaticbrightness

import android.os.Bundle
import android.os.Handler
import android.provider.Settings
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var brightnessObserver: BrightnessObserver? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Configurar el brillo al máximo
        setBrightnessToMax()

        // Crear e iniciar el observador de brillo
        brightnessObserver = BrightnessObserver(this, Handler())
        contentResolver.registerContentObserver(
            Settings.System.getUriFor(Settings.System.SCREEN_BRIGHTNESS), true, brightnessObserver!!
        )
    }

    private fun setBrightnessToMax() {
        val layoutParams = window.attributes
        layoutParams.screenBrightness = 1.0f // Establecer brillo al máximo
        window.attributes = layoutParams
    }
}
