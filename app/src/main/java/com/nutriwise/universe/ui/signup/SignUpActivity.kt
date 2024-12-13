package com.nutriwise.universe.ui.signup

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowManager
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.google.gson.Gson
import com.nutriwise.universe.R
import com.nutriwise.universe.data.network.service.UserRegister
import com.nutriwise.universe.databinding.ActivitySignUpBinding
import com.nutriwise.universe.ui.ViewModelFactory
import com.nutriwise.universe.ui.signin.SignInActivity
import com.nutriwise.universe.ui.util.isNetworkConnected
import com.nutriwise.universe.ui.util.showToast
import kotlinx.coroutines.launch
import retrofit2.HttpException

class SignUpActivity : AppCompatActivity() {
    private lateinit var context: Context
    private var _binding: ActivitySignUpBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModels<SignUpViewModel> {
        ViewModelFactory.getInstance(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        context = this@SignUpActivity
        showLoading(false)
        supportActionBar?.hide()
        setupView()
        setupAction()

        binding.signinButton.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }

    }

    private fun setupView() {
        @Suppress("DEPRECATION")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
        supportActionBar?.hide()
    }

    private fun setupAction() {
        binding.signupButton.setOnClickListener {
            showLoading(true)
            val name = binding.nameEditText.text.toString()
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()

            if (name.isEmpty()) {
                binding.nameEditTextLayout.error = "Nama Tidak Boleh Kosong"
            } else if (email.isEmpty()) {
                binding.emailEditTextLayout.error = "Email Tidak Boleh Kosong"
            } else if (password.isEmpty()) {
                binding.passwordEditTextLayout.error = "Password Tidak Boleh Kosong"
            }else if (
                binding.passwordEditText.error.isNullOrBlank() &&
                binding.emailEditText.error.isNullOrBlank() &&
                binding.nameEditText.error.isNullOrBlank()
                ) {
                if (isNetworkConnected(context)) {
                    if(viewModel.register(this, name, email, password)){
                        showLoading(false)
                    } else {
                        showLoading(false)
                    }
                } else {
                    showLoading(false)
                    showToast(context, "Tidak Ada Internet")
                }
            }
        }
    }

    private fun showLoading(isLoading: Boolean) {
        binding.progressBarSignup.visibility =
            if (isLoading) View.VISIBLE else View.GONE
        binding.signupButton.isEnabled = !isLoading
    }
}