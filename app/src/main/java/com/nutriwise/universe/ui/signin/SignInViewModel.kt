package com.nutriwise.universe.ui.signin

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nutriwise.universe.MainActivity
import com.nutriwise.universe.data.network.repository.AppRepository
import com.nutriwise.universe.data.network.service.UserSignIn
import com.nutriwise.universe.data.userPref.UserModel
import com.nutriwise.universe.ui.util.showToast
import kotlinx.coroutines.launch

class SignInViewModel(val appRepository: AppRepository): ViewModel() {

    fun userSignIn(context: Context, email: String, password: String): Boolean {
        var loginSuccess = false
        viewModelScope.launch {
            try {
                val response = appRepository.signInUser(email, password)
                if (response.token.isNotEmpty()){
                    loginSuccess = true
                    val userModel = UserModel(
                        token = response.token,
                        email = email,
                        password = password,
                        true)
                    appRepository.saveSession(userModel)
                    showToast(context, "Berhasil Masuk")
                    val intent = Intent(context, MainActivity::class.java)
                    context.startActivity(intent)
                    Log.d("SignUpViewModel", "Register Berhasil")
                }else{
                    loginSuccess = false
                    showToast(context, "Gagal Masuk")
                    Log.d("SignUpViewModel", "Register Failed")
                }
            } catch (e: Exception){
                loginSuccess = false
                Log.d("SignUpViewModel", "Register Failed With Exception :  ${e.toString()}")
            }
        }
        return loginSuccess
    }
}