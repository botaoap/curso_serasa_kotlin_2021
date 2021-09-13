package com.serasa.pixabay_image_video.view_model

import android.graphics.pdf.PdfDocument
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.serasa.pixabay_image_video.model.Image
import com.serasa.pixabay_image_video.model.VideoConfig
import com.serasa.pixabay_image_video.repository.PixabayImageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.sql.SQLTransactionRollbackException
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: PixabayImageRepository
) : ViewModel() {

    private val _image = MutableLiveData<List<Image>>()
    var image: LiveData<List<Image>> = _image

    private val _video = MutableLiveData<List<VideoConfig>>()
    var video: LiveData<List<VideoConfig>> = _video

    fun fetchImage(q: String = "", page: Int) {
        viewModelScope.launch {
            repository.fetchImage(q = q, page = page)?.let {
                _image.value = it
            }
        }
    }

    fun fetchVideo(q: String, page: Int) {
        viewModelScope.launch {
            repository.fetchVideo(q = q, page = page)?.let {
                _video.value = it
            }
        }
    }

}