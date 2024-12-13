package com.nutriwise.universe.data.userPref

data class UserModel (
    val token: String,
    val email: String,
    val password: String,
    val isLogin: Boolean
)