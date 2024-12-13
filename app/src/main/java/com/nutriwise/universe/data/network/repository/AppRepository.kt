package com.nutriwise.universe.data.network.repository

import com.nutriwise.universe.data.network.response.RegisterResponse
import com.nutriwise.universe.data.network.response.SignInResponse
import com.nutriwise.universe.data.network.service.ApiService
import com.nutriwise.universe.data.network.service.UserRegister
import com.nutriwise.universe.data.network.service.UserSignIn
import com.nutriwise.universe.data.userPref.UserModel
import com.nutriwise.universe.data.userPref.UserPreference
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody

class AppRepository private constructor(
   val apiService: ApiService,
   val userPreference: UserPreference
){

   suspend fun saveSession(user: UserModel) {
      userPreference.saveSession(user)
   }

   suspend fun registerUser(name: String, email: String, password: String): RegisterResponse {
      val nameRequestBody = RequestBody.create("application/json".toMediaTypeOrNull(), name)
      val emailRequestBody = RequestBody.create("application/json".toMediaTypeOrNull(), email)
      val passwordRequestBody = RequestBody.create("application/json".toMediaTypeOrNull(), password)
      return apiService.registerUser(nameRequestBody, emailRequestBody, passwordRequestBody)
   }

   suspend fun signInUser(email: String,password: String): SignInResponse {
      val emailRequestBody = RequestBody.create("application/json".toMediaTypeOrNull(), email)
      val passwordRequestBody = RequestBody.create("application/json".toMediaTypeOrNull(), password)
      return apiService.login(emailRequestBody, passwordRequestBody)
   }

   companion object {
      fun clearInstance() {
         instance = null
      }

      @Volatile
      private var instance: AppRepository? = null
      fun getInstance(
         service: ApiService,
         userPreference: UserPreference
      ): AppRepository =
         instance ?: synchronized(this) {
            instance ?: AppRepository(service, userPreference)
         }.also { instance = it }
   }
}