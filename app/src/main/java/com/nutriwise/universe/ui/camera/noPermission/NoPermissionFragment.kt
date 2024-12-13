package com.nutriwise.universe.ui.camera.noPermission

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import com.nutriwise.universe.databinding.FragmentNoPermissionBinding
import com.nutriwise.universe.ui.camera.CameraActivity
import com.nutriwise.universe.ui.util.showToast

class NoPermissionFragment : Fragment() {

    private var _binding: FragmentNoPermissionBinding? = null
    private val binding get() = _binding!!

    private val requestPermissionsLauncher =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
            val allGranted = permissions.values.all { it }
            if (allGranted) {
                // If all permissions are granted, navigate to CameraActivity
                val intent = Intent(requireContext(), CameraActivity::class.java)
                startActivity(intent)
            } else {
                // Show a toast if permissions are denied
                showToast(requireContext(), "Berikan Izin Terlebih Dahulu")
            }
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNoPermissionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnOpenCamera.setOnClickListener {
            checkPermissions()
        }
    }

    private fun checkPermissions() {
        val requiredPermissions = arrayOf(
            Manifest.permission.CAMERA,
            Manifest.permission.READ_MEDIA_IMAGES
        )

        val allPermissionsGranted = requiredPermissions.all { permission ->
            ContextCompat.checkSelfPermission(requireContext(), permission) == PackageManager.PERMISSION_GRANTED
        }

        if (allPermissionsGranted) {
            // Navigate to CameraActivity if all permissions are already granted
            val intent = Intent(requireContext(), CameraActivity::class.java)
            startActivity(intent)
        } else {
            // Request necessary permissions
            requestPermissionsLauncher.launch(requiredPermissions)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
