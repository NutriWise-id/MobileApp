package com.nutriwise.universe

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.nutriwise.universe.databinding.ActivityMainBinding
import com.nutriwise.universe.ui.camera.CameraActivity
import com.nutriwise.universe.ui.util.showToast

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.bottomNavigation

        val navController = findNavController(R.id.fragment_controller_view)
        AppBarConfiguration.Builder(
            R.id.navigation_home,
            R.id.navigation_learning,
            R.id.navigation_calculator,
            R.id.navigation_camera
        ).build()

        navView.setupWithNavController(navController)
        navView.setOnItemSelectedListener { item ->
            if (item.itemId == R.id.navigation_camera){
                if (checkCameraPermission()) {
                    startActivity(Intent(this, CameraActivity::class.java))
                } else {
                    navController.navigate(item.itemId)
                }
                true
            }else{
                navController.navigate(item.itemId)
                true
            }
        }
    }


    private fun checkCameraPermission(): Boolean {
        return ContextCompat.checkSelfPermission(
            this,
            android.Manifest.permission.CAMERA
        ) == PackageManager.PERMISSION_GRANTED
    }
}