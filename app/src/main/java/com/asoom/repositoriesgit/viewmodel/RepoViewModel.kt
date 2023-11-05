package com.asoom.repositoriesgit.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.asoom.domain.entity.GitHubRepo
import com.asoom.domain.usecase.FetchRepositoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RepoViewModel @Inject constructor(
    private val fetchRepositoriesUseCase: FetchRepositoriesUseCase
) : ViewModel() {

    private val _repositories = MutableLiveData<List<GitHubRepo>>()
    val repositories: LiveData<List<GitHubRepo>> = _repositories

//    init {
//        // Initially, fetch repositories when the ViewModel is created
//        fetchRepositories()
//        val result = fetchRepositories()
//        Log.d("Print", "RepoViewModel: $result ")
//
//    }

    // Function to fetch repositories

    fun fetchRepositories() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val newRepositories = fetchRepositoriesUseCase.fetchRepositories()

                // Update the LiveData with the fetched data on the main thread
                viewModelScope.launch(Dispatchers.Main) {
                    _repositories.value = newRepositories
                }
            } catch (e: Exception) {
                // Handle errors and update the error LiveData on the main thread
                viewModelScope.launch(Dispatchers.Main) {
                    // Example: _errorLiveData.value = e.message
                }
            }
        }
    }

}

