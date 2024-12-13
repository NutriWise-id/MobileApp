package com.nutriwise.universe.ui.signup

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nutriwise.universe.data.network.repository.AppRepository
import com.nutriwise.universe.data.network.service.UserRegister
import com.nutriwise.universe.data.userPref.UserModel
import com.nutriwise.universe.ui.signin.SignInActivity
import com.nutriwise.universe.ui.util.showToast
import kotlinx.coroutines.launch

class SignUpViewModel(val appRepository: AppRepository): ViewModel() {

    fun register(context: Context, name: String, email: String, password: String):Boolean{
        var registerSuccess: Boolean = false
        viewModelScope.launch {
            try {
                val response = appRepository.registerUser(name, email, password)
                if (response.Success){
                    val intent = Intent(context, SignInActivity::class.java)
                    context.startActivity(intent)
                    showToast(context, "Akun Berhasil Dibuat")
                    Log.d("SignUpViewModel", "Register Berhasil")
                    registerSuccess = true
                }else{
                    registerSuccess = false
                    showToast(context, "Akun Gagal Dibuat")
                    Log.d("SignUpViewModel", "Register Failed")
                }
            } catch (e: Exception){
                registerSuccess = false
                Log.d("SignUpViewModel", "Register Failed With Exception :  ${e.toString()}")
            }
        }
        return registerSuccess
    }
}