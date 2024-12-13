package com.nutriwise.universe.ui.signin

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
import com.nutriwise.universe.data.network.service.UserSignIn
import com.nutriwise.universe.databinding.ActivitySignInBinding
import com.nutriwise.universe.ui.ViewModelFactory
import com.nutriwise.universe.ui.signup.SignUpActivity
import com.nutriwise.universe.ui.util.isNetworkConnected
import kotlinx.coroutines.launch
import retrofit2.HttpException

class SignInActivity : AppCompatActivity() {

    private lateinit var context: Context
    private val viewModel by viewModels<SignInViewModel> {
        ViewModelFactory.getInstance(this)
    }

    private var _binding: ActivitySignInBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        context = this@SignInActivity

        supportActionBar?.hide()
        setupAction()
        setupView()

        binding.btnSignUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
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
        binding.btnSignIn.setOnClickListener {
            showLoading(true)
                val email = binding.emailEditText.text.toString()
                val password = binding.passwordEditText.text.toString()

                if (email.isEmpty()) {
                    binding.emailEditText.error = "Email Tidak Boleh Kosong"
                } else if (password.isEmpty()) {
                    binding.passwordEditText.error = "Password Tidak Boleh Kosong"
                } else {
                    if (isNetworkConnected(this)) {
                        if (viewModel.userSignIn(context, email, password)){
                            showLoading(false)
                        } else {
                            showLoading(false)
                        }
                    }
                }
        }
    }

    private fun showLoading(isLoading: Boolean) {
        binding.progressBarSignup.visibility =
            if (isLoading) View.VISIBLE else View.GONE
        binding.btnSignIn.isEnabled = !isLoading
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}