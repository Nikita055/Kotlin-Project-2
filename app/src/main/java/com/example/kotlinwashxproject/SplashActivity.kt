package com.example.kotlinwashxproject

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.WindowManager
import com.example.kotlinwashxproject.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

  private var SPLASH_TIMEOUT: Long = 3000

  /*  private lateinit var binding: ActivitySplashBinding*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

      val binding = ActivitySplashBinding.inflate(layoutInflater)
      val view : View = binding.root
        setContentView(view)
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
      window.attributes.layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES
    }

    navigateToNextScreen()

    }

  private fun navigateToNextScreen() {
    Handler(Looper.getMainLooper()).postDelayed({
      startActivity(Intent(this, LoginActivity::class.java))
      finish()
    }, SPLASH_TIMEOUT)

  }
}