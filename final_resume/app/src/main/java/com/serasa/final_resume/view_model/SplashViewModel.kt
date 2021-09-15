package com.serasa.final_resume.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.serasa.final_resume.model.Image
import com.serasa.final_resume.repository.PixabayRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val repository: PixabayRepository
) : ViewModel() {

    private val _imageDb = MutableLiveData<List<Image>>()
    var imageDb: LiveData<List<Image>> = _imageDb

    private val _image = MutableLiveData<List<Image>>()
    var image: LiveData<List<Image>> = _image

    private val _insert = MutableLiveData<Boolean>()
    var insert: LiveData<Boolean> = _insert

    fun fetchImage(q: String, page: Int) {
        viewModelScope.launch {
            repository.fetchImage(q = q, page = page).let { listImage ->
                _image.value = listImage
            }
            delay(2000)
        }
    }

    fun insert(listOf: List<Image>) {
        viewModelScope.launch {
            delay(2000)
            repository.insert(listOf).let { insertImage ->
                _insert.value = insertImage
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