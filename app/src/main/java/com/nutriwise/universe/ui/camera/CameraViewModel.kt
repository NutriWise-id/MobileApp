package com.nutriwise.universe.ui.camera

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nutriwise.universe.data.network.repository.AppRepository
import com.nutriwise.universe.data.network.response.UploadResponse
import kotlinx.coroutines.launch
import okhttp3.MultipartBody

class CameraViewModel (private val appRepository: AppRepository) : ViewModel() {
    val uploadResponse: LiveData<UploadResponse> = appRepository.

    fun uploadFile(file: MultipartBody.Part) {
        viewModelScope.launch {
            appRepository.uploadFile(file)
        }
    }
}