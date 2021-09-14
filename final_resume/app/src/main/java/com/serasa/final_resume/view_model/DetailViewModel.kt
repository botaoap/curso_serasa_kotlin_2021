package com.serasa.final_resume.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.serasa.final_resume.model.Image
import com.serasa.final_resume.repository.PixabayRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private var repository: PixabayRepository
) : ViewModel() {

}