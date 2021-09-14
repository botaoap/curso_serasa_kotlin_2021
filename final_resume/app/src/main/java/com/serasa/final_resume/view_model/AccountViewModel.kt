package com.serasa.final_resume.view_model

import androidx.lifecycle.ViewModel
import com.serasa.final_resume.repository.PixabayRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AccountViewModel @Inject constructor(
    private var repository: PixabayRepository
): ViewModel() {
    // TODO: Implement the ViewModel
}