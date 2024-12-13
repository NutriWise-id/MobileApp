package com.nutriwise.universe.ui.camera

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nutriwise.universe.data.network.repository.AppRepository
import kotlinx.coroutines.launch
import okhttp3.MultipartBody

class CameraViewModel (private val appRepository: AppRepository) : ViewModel() {
    val uploadResponse: LiveData<UploadResponse> = appRepository.uploadResponse

    fun uploadFile(file: MultipartBody.Part, daerah: String) {
        viewModelScope.launch {
            appRepository.uploadFile(file, daerah)
        }
    }

    val _scanResponse = MutableLiveData<ScanResponse>()
    val scanResponse : LiveData<ScanResponse> =  _scanResponse
    fun scanImageResult() {
        viewModelScope.launch {
//            _scanResponse.value = appRepository.getScanResult()
        }
    }
}