package com.nutriwise.universe.data.network.service

import com.nutriwise.universe.data.network.response.RegisterResponse
import com.nutriwise.universe.data.network.response.SignInResponse
import com.nutriwise.universe.data.network.response.UploadResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part


interface ApiService {
//
//    @POST("register")
//    suspend fun registerUser(
//        @Body userRegister: UserRegister
//    ):RegisterResponse

    @Multipart
    @POST("register")
    suspend fun registerUser(
        @Part("name") name: RequestBody,
        @Part("email_address") email: RequestBody,
        @Part("password") password: RequestBody
    ):RegisterResponse

    @Multipart
    @POST("auth/login")
    suspend fun login(
        @Part("email_address") email: RequestBody,
        @Part("password") password: RequestBody
    ):SignInResponse

    @Multipart
    @POST("predict/{daerah}")
    suspend fun uploadImage(
        @Part file: MultipartBody.Part,
    ): UploadResponse

//    fun RegisterUser() {
//        // Buat instance OkHttpClient
//        val client = OkHttpClient()
//
//        // Buat MultipartBody untuk form-data
//        val body = MultipartBody.Builder()
//            .setType(MultipartBody.FORM) // Pastikan menggunakan form-data
//            .addFormDataPart("name", "9")
//            .addFormDataPart("email_address", "9@gmail.com")
//            .addFormDataPart("password", "9")
//            .build()
//
//        // Buat request ke endpoint
//        val request = Request.Builder()
//            .url("https://rails-service-361257081145.asia-southeast2.run.app/register")
//            .post(body)
//            .addHeader("Content-Type", "multipart/form-data") // Set header sebagai multipart/form-data
//            .build()
//
//        // Eksekusi request secara asinkron
//        client.newCall(request).enqueue(object : Callback {
//            override fun onFailure(call: Call, e: IOException) {
//                // Tangani kesalahan
//                e.printStackTrace()
//                println("Request failed: ${e.message}")
//            }
//
//            override fun onResponse(call: Call, response: Response) {
//                response.use {
//                    if (!response.isSuccessful) {
//                        println("Request failed with code: ${response.code}")
//                    } else {
//                        println("Response: ${response.body?.string()}")
//                    }
//                }
//            }
//        })
//    }

//    @POST("/auth/login")
//    suspend fun login(
//        @Body userSignIn: UserSignIn
//    ): SignInResponse
//
//    @Multipart
//    @POST("predict/{daerah}")
//    suspend fun uploadImage(
//        @Part file: MultipartBody.Part,
//        @retrofit2.http.Path("daerah") daerah: String
//    ): UploadResponse
}