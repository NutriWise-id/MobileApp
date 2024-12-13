package com.nutriwise.universe.ui.camera.result

import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.nutriwise.universe.R
import com.nutriwise.universe.databinding.ActivityResultBinding
import com.nutriwise.universe.ui.camera.CameraActivity
import com.nutriwise.universe.ui.util.getRotatedBitmap
import com.nutriwise.universe.ui.util.showToast
import java.io.File

class ResultActivity : AppCompatActivity() {

    private var _binding: ActivityResultBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Hasil Scan"

        val imageUrlCamera = intent.getStringExtra(CameraActivity.EXTRA_CAMERA_IMAGE)?.toUri()
        val imageUrlGallery = intent.getStringExtra(CameraActivity.EXTRA_GALLERY_IMAGE)?.toUri()
        val scanResult = intent.getStringExtra(CameraActivity.EXTRA_RESULT_SCANNER)

        if (imageUrlCamera != null) {
            val bitmap = BitmapFactory.decodeFile(imageUrlCamera.path)
            val rotatedBitmap = bitmap.getRotatedBitmap(File(imageUrlCamera.path.toString()))
            binding.ivPhotoResultScan.setImageBitmap(rotatedBitmap)
            binding.ivPhotoResultScan.scaleType = ImageView.ScaleType.CENTER_CROP
        } else if (imageUrlGallery != null) {
            binding.ivPhotoResultScan.setImageURI(imageUrlGallery)
            binding.ivPhotoResultScan.scaleType = ImageView.ScaleType.CENTER_CROP
        } else {
            showToast(this, "Gambar Tidak Ada")
        }

        binding.btnDeteksiUlang.setOnClickListener {
            val intent = Intent(this, CameraActivity::class.java)
            startActivity(intent)
        }

        if (scanResult != null) {
            binding.tvScanResult.text = scanResult.toString()
        } else {
            showToast(this, "Scan Gagal")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        finish()
        return true
    }

    companion object
}