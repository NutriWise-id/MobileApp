package com.nutriwise.universe.ui.splashscreen

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.nutriwise.universe.R
import com.nutriwise.universe.ui.onBoarding.feature.onboarding.OnBoardingActivity
import com.nutriwise.universe.ui.onBoarding.prefmanager.OnBoardingPrefManager
import com.nutriwise.universe.ui.signin.SignInActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {
    private lateinit var onBoardingPrefManager: OnBoardingPrefManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash)

        onBoardingPrefManager = OnBoardingPrefManager(this)

        lifecycleScope.launch {
            delay(2000)
            if (onBoardingPrefManager.isFirstTimeLaunch){
                val intent = Intent(this@SplashActivity, OnBoardingActivity::class.java)
                startActivity(intent)
            }else{
                val intent = Intent(this@SplashActivity, SignInActivity::class.java)
                startActivity(intent)
            }
        }
    }
}