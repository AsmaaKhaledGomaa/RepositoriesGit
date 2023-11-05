package com.asoom.repositoriesgit.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.asoom.domain.entity.RepoDetails
import com.asoom.domain.usecase.FetchRepoDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RepoDetailsViewModel @Inject constructor(
    private val fetchRepoDetailsUseCase: FetchRepoDetailsUseCase
) : ViewModel() {

    private val _repositoryDetails = MutableStateFlow<RepoDetails?>(null)
    val repositoryDetails: StateFlow<RepoDetails?> = _repositoryDetails


    fun fetchRepoDetails(owner: String, repo: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val newRepoDetails = fetchRepoDetailsUseCase(owner, repo)
                Log.d("Print", "DetailsViewModel: $newRepoDetails")
                _repositoryDetails.value = newRepoDetails
            } catch (e: Exception) {
                Log.e("print", "RepoDetailsViewModel: Error fetching details: $e")
            }
        }
    }
}