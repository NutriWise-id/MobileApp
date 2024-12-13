package com.nutriwise.universe.data.di

import android.content.Context
import com.nutriwise.universe.data.network.repository.AppRepository
import com.nutriwise.universe.data.network.service.ApiConfig
import com.nutriwise.universe.data.userPref.UserPreference
import com.nutriwise.universe.data.userPref.dataStore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

object Injection {
    fun provideRepository(context: Context): AppRepository = runBlocking {
        val preference = UserPreference.getInstance(context.dataStore)
        val user = preference.getSession().first()
        val apiService = ApiConfig.getApiService(user.token)
        AppRepository.getInstance(apiService, preference)
    }
}