package com.serasa.final_resume.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.serasa.final_resume.model.Image
import com.serasa.final_resume.repository.PixabayRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FeedViewModel @Inject constructor(
    private var repository: PixabayRepository
) : ViewModel() {

    var image = MutableLiveData<List<Image>>()

    private val _imageDb = MutableLiveData<List<Image>>()
    var imageDb: LiveData<List<Image>> = _imageDb

    fun fetchImage(q: String, page: Int) {
        viewModelScope.launch {
            repository.fetchImage(q, page)?.let { response ->
                image.value = response
            }
        }
    }


    fun fetchImageFromDb() {
        viewModelScope.launch {
            repository.fetchImageFromDb().let { listImageFromDb ->
                _imageDb.value = listImageFromDb
            }
        }
    }
}