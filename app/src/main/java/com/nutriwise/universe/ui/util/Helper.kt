package com.nutriwise.universe.ui.util

import android.content.Context
import android.net.ConnectivityManager
import android.widget.Toast

fun isNetworkConnected(context: Context): Boolean {
    val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val networkInfo = connectivityManager.activeNetworkInfo
    return networkInfo != null && networkInfo.isConnected
}

fun showToast(context: Context, message: String?) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}